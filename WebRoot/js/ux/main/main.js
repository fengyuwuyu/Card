/*声明命名空间*/
$package('YiYa.main');

/* 封装变量（利用匿名自执行函数） */
YiYa.main = function() {
	return {
		treeSelect : function() {
			var _this = $(this);
			var title = _this.text();
			var url = _this.attr('href');
			YiYa.main.addTab(title, url);
			return false;
		},
		synchronize : function(type) {
			window.goSync=1;
			YiYa.closeShow();
			if (type == 1) {
				YiYa.main.addTab("部门管理", urls['msUrl'] + "view/sys/dtDep.jsp");
			} else if (type == 2) {
				YiYa.main.addTab("员工管理", urls['msUrl'] + "view/sys/dtUser.jsp?goSync=1");
			}
		},
		isSynchronized : function() {
			setTimeout(
					function() {
						YiYa.ajaxJson(urls['msUrl']+ 'systemController/midUserSynchronizeCount.do',null,function(data) {
											if (data.count > 0) {
												var now = YiYa.showTime();
												YiYa.show('截至'+ now+ '，有 '+ data.count
																		+ ' 条员工更新，去<a href=\'#\' onclick=\'YiYa.main.synchronize(2)\'>接收</a>！',
																5000, true);
											}
										});
					}, 0);
		},
		treeInit : function() {
			var $items = $('#tree-box').find(".tree-item");
			$items.bind('click', this.treeSelect);
		},
		addTab : function(_title, _url) {
			var boxId = '#tab-box';
			if ($(boxId).tabs('exists', _title)) {
				var tab = $(boxId).tabs('getTab', _title);
				var index = $(boxId).tabs('getTabIndex', tab);
				$(boxId).tabs('select', index);
				if (tab && tab.find('iframe').length > 0) {
					var _refresh_ifram = tab.find('iframe')[0];
					_refresh_ifram.contentWindow.location.href = _url;
				}
			} else {
				var _content = "<iframe scrolling='auto' frameborder='0' src='"
						+ _url + "' style='width:100%; height:100%'></iframe>";
				$(boxId).tabs('add', {
					title : _title,
					content : _content,
					closable : true
				});

			}
		},
		menuHover : function() {
			// 菜单鼠标进入效
			$('.tree-item').hover(function() {
				$(this).stop().animate({
					paddingLeft : "25px"
				}, 200, function() {
					$(this).addClass("orange");
				});
			}, function() {
				$(this).stop().animate({
					paddingLeft : "15px"
				}, function() {
					$(this).removeClass("orange");
				});
			});
		},
		selectTheme : function(id) {
			$.each($('.item-theme'), function(i, n) {
				$('#menu-theme').menu('setIcon', {
					target : n,
					iconCls : ''
				});
			});
			$('#menu-theme').menu('setIcon', {
				target : $('#' + id),
				iconCls : 'icon-yes'
			});
		},
		changeTheme : function(item) {
			var theme = item.id;
			YiYa.main.selectTheme(theme);
			var href = urls['msUrl'] + 'js/jquery-easyui-1.4.0/themes/' + theme
					+ '/easyui.css';
			$('#theme').attr('href', href);
			var $iframe = $('iframe');
			if ($iframe.length > 0) {
				for (var i = 0; i < $iframe.length; i++) {
					var ifr = $iframe[i];
					$(ifr).contents().find('#theme').attr('href', href);
				}
			}
			$.cookie('theme', theme, {
				expires : 30,
				path : '/'
			});
		},
		init : function() {
			this.treeInit();
			this.menuHover();
			// 修改密码绑定事件
			$('.modify-pwd-btn').click(
					function() {
						$('#pwdForm').form('reset');
						$('#modify-pwd-win').dialog('open');
					});
			$('#btn-pwd-submit').click(
					function() {
						if ($('#pwdForm').form('validate')) {
							var pswd1 = $('#userPassword').val();
							var pswd2 = $('#userPassword1').val();
							if(pswd1!=pswd2){
								YiYa.alert("提示", "两次输入的密码不一致！" );
								return ;
							}
							var oldUserPassword = $('#oldUserPassword').val();
							YiYa.ajaxJson(urls['msUrl'] + 'main/checkPswd.do', 
								{
									oldUserPassword:oldUserPassword
								}, 
							 function(data){
								if(!data.success){
									YiYa.alert("提示", data.msg );
								}else{
									YiYa.progress('请求中...');
									$('#pwdForm').attr('action',
											urls['msUrl'] + 'main/editPwd.do');
									YiYa.submitForm($('#pwdForm'), function(data) {
										if (data.success) {
											$('#modify-pwd-win').dialog('close');
											YiYa.alert('提示信息', data.msg, 'info');
										} else {
											YiYa.alert('提示信息', data.msg, 'info');
										}
									});
								}
							});
						}
					});
			$('#btn-pwd-close').click(function() {
				$('#modify-pwd-win').dialog('close');
			});
			$('#menu-theme').menu({
				onClick : function(item) {
					YiYa.main.changeTheme(item);
				}
			});
			var theme = $.cookie('theme') || 'default';
			YiYa.main.selectTheme(theme);
			setInterval(function() {
				$('#time').html(YiYa.showTime());
			}, 1000);
			if (YiYa.needServerNotify()) {
				this.isSynchronized();
				// 注册dwr监听器
				dwr.engine.setActiveReverseAjax(true);
				dwr.engine.setNotifyServerOnPageUnload(true);
				SynchronizeDep.onPageLoad('synchronizeDep');
			}

		}
	};
}();

/* 页面初始化 */
$(function() {
	YiYa.main.init();
});

function synchronizeDep(count, type) {
	var now = YiYa.showTime();
//	if (type == 1) {
//		YiYa.show('截至'+ now+ '，有 '+ count+ ' 条部门更新，去<a href=\'#\' onclick=\'YiYa.main.synchronize(1)\'>接收</a>！',0, true);
//	} else if (type == 2) {
//		YiYa.show('截至'+ now+ '，有 '+ count+ ' 条人员更新，去<a href=\'#\' onclick=\'YiYa.main.synchronize(2)\'>接收</a>！',0, false);
//	}
	YiYa.ajaxJson(urls['msUrl']+ 'systemController/midUserSynchronizeCount.do',null,function(data) {
		if (data.count > 0) {
			var now = YiYa.showTime();
			YiYa.show('截至'+ now+ '，有 '+ data.count
									+ ' 条员工更新，去<a href=\'#\' onclick=\'YiYa.main.synchronize(2)\'>接收</a>！',
							5000, true);
		}
	});
}