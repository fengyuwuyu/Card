/*声明命名空间*/
$package('YiYa.stDoor');

/* 封装变量（匿名自执行函数） */
YiYa.stDoor = function() {
	var _box = null;
	var _this = {
		config : {
			event : {
				add : function(){
					_box.form.edit.form('reset');
					$('#depSerial').combotree({'disabled':false});
					_box.win.edit.window('open');
				},
				edit : function(){
					var rows = _box.utils.getCheckedRows();
					if(_box.utils.checkSelectOne(rows)){
						$('#depSerial').combotree({'disabled':true});
						var data ={};
						var idKey = _this.config.dataGrid.idField || 'id';//主键名称
	 					data[idKey] = (rows[0][idKey]);
						YiYa.getById(_this.config.action.getById,data,function(result){
							_box.form.edit.form('reset');
							_box.form.edit.form('load',result.data);
							_box.win.edit.dialog('open'); 
						});
					}
				}
			},
			action : {
				save : urls['msUrl'] + 'stDoorReal/save.do',// 保存Action
				getById : urls['msUrl'] + 'stDoorReal/getById.do',// 查询Action
				remove : urls['msUrl'] + 'stDoorReal/delete.do'// 删除Action
			},
			dataGrid : {
				url : urls['msUrl'] + 'stDoorReal/dataList.do',
				idField : 'bh',
				columns : [ [ {
					field : 'ck',
					checkbox : true
				}, {
					field : 'bh',
					hidden : true
				}, {
					field : 'mj',
					hidden : true
				}, {
					field : 'depName',
					title : '场所名称',
					align : 'center',
					width : 80,
					sortable : true
				}, {
					field : 'doorName',
					title : '门名称',
					align : 'center',
					width : 100,
					sortable : true
				}, {
					field : 'devName',
					title : '设备名称',
					align : 'center',
					width : 80,
					sortable : true
				}, {
					field : 'ip',
					title : '设备ip',
					align : 'center',
					width : 60,
					sortable : true
				}, ] ],
				toolbar : [ {
					id : 'btn-add',
					text : '添加',
					btnType : 'add'
				}, {
					id : 'btn-edit',
					text : '修改',
					btnType : 'edit'
				}, {
					id : 'btn-remove',
					text : '删除',
					btnType : 'remove'
				}, ]
			}
		},
		init : function() {
			_box = new YDataGrid(_this.config);
			_box.init();
			$('input[placeholder]').placeholder();
			$('#selDev').click(function() {
				$('#chooseDev-win').window('open');
				$('#data-list2').datagrid({
					height : 309,
					width : 'auto',
					fitColumns : true,
					nowrap : false,
					autoRowHeight : false,
					striped : true,
					remoteSort : false,
					pagination : true,
					rownumbers : true,
					singleSelect : true,
					checkOnSelect : true,
					selectOnCheck : true,
					url : urls['msUrl'] + 'stDoorReal/selectMjDev.do',
					method : 'post',
					loadMsg : '加载中 ... ',
					idField : 'bh',
					columns : [ [ {
						field : 'ck',
						checkbox : true
					}, {
						field : 'bh',
						hidden : true
					}, {
						field : 'mc',
						title : '设备名称',
						align : 'center',
						width : 150,
						sortable : true
					}, {
						field : 'ip',
						title : '设备ip',
						align : 'center',
						width : 150,
						sortable : true
					} ] ],
					onSelect : function(rowIndex, rowData){
						var devOrder = rowData.devOrder;
						$('#radio1').attr('disabled',false);
						$('#devOrder1').html("1号门锁接口");
						$('#radio2').attr('disabled',false);
						$('#devOrder2').html("2号门锁接口");
						var len = devOrder.length;
						var ra1 = $('#radio1');
						var ra2 = $('#radio2');
						if(len==0){
							YiYa.radioCheck(ra1, true);
						}else if(len==1){
							if(devOrder[0]==1){
								ra1.attr('disabled',true);
								$('#devOrder1').html("1号门锁接口"+"<span style='color:red'>(已分配)</span>");
								YiYa.radioCheck(ra2, true);
							}else{
								ra2.attr('disabled',true);
								$('#devOrder2').html("2号门锁接口"+"<span style='color:red'>(已分配)</span>");
								YiYa.radioCheck(ra1, true);
							}
						}else{
							ra1.attr('disabled',true);
							$('#devOrder1').html("1号门锁接口"+"<span style='color:red'>(已分配)</span>");
							ra2.attr('disabled',true);
							$('#devOrder2').html("2号门锁接口"+"<span style='color:red'>(已分配)</span>");
							YiYa.radioCheck(ra1, false);
							YiYa.radioCheck(ra2, false);
						}
					} 
				});
			});
			
			$('#btn-save2').click(function(){
				var checked = $('input:radio[name="devOrder"]:checked').val();
				if(checked){
					var rows = $('#data-list2').datagrid('getChecked');
					if(rows&&rows.length==1){
						$('#devName').textbox('setValue',rows[0].mc+" "+(checked==1?"1号门锁接口":"2号门锁接口"));
						$('#devSerial').val(rows[0].bh);
						$('#devOrder').val(checked);
					}
				}
				$('#chooseDev-win').window('close');
			});
			
			$('#btn-close2').click(function(){
				$('#chooseDev-win').window('close');
			});
		}
	}
	return _this;
}();

/* 页面初始化 */
$(function() {
	YiYa.stDoor.init();
});