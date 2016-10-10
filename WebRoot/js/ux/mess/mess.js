function depSerialCon() {
	var depSerial = $('#depSerial');
	if (!depSerial) {
		return;
	}
	depSerial.combotree({onCheck : function(node, checked) {
		if (checked) {
			var combotree = $("input[name='depSerial']").parent();
			$("input[name='depSerial']").remove();
			var tree = depSerial.combotree('tree');
			var parent = $(tree).tree('getParent', node.target);
			var checkValues = '';
			var checkIds = [];
			var checkeds = $(tree).tree('getChecked');
			if (parent) {
				$('#' + parent.domId + '>span[class="tree-checkbox tree-checkbox1"')
						.attr('class', 'tree-checkbox tree-checkbox0');
				var parentId = parent.id;
				checkIds.push(parentId);
				// for(var i=0;i<checkeds.length;i++){
				// if(checkeds[i].id==parentId){
				// checkValues+=checkeds[i].text+',';
				//						
				// $('<input class="textbox-value" type="hidden"
				// name="depSerial">').attr('value',checkeds[i].id).appendTo(combotree);
				// }
				// }
				// checkValues = checkValues.substring(0,
				// checkValues.length-1);
				// depSerial.combotree('setText',checkValues);
			}
			if (node.children) {
				checkValues = '';
				var lisDom = $('#'+ node.domId+ '~ul li span[class="tree-checkbox tree-checkbox1"');
				// 勾选时若存在下级部门，则使下级部门全部不选择
				lisDom.each(function(index, li) {
					$(this).attr('class',
							'tree-checkbox tree-checkbox0');
				});
				var children = $(tree).tree('getChildren',
						node.target);
				if (children) {
					for (var j = 0; j < children.length; j++) {
						checkIds.push(children[j].id);
					}
				}
			}
			for(var i=0;i<checkeds.length;i++){
				var _b = false;
				for(var j=0;j<checkIds.length;j++){
					if(checkeds[i].id==checkIds[j]){
						_b=true;
						break;
					}
				}
				if(!_b){
					$('<input class="textbox-value" type="hidden" name="depSerial">')
					.attr('value', checkeds[i].id)
					.appendTo(combotree);
					checkValues += checkeds[i].text + ',';
				}
			}
			checkValues = checkValues.substring(0,checkValues.length - 1);
			depSerial.combotree('setText', checkValues);
		}
	}});
}