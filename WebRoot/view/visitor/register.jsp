<%@page language="java" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!DOCTYPE html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <title>访客登记</title>
	    <%@include file="../resource.jsp"%>  		
		<script type="text/javascript" src="../../js/commons/YDataGrid.js"></script>
		<script type="text/javascript" src="../../js/ux/visitor/register.js"></script>
	</head>
	<body>
	
		<object id="object" classid="clsid:DE96678E-5929-4FC1-9640-D7FB380E4F93" class="hidden" ></object>
		<OBJECT classid="clsid:10EC554B-357B-4188-9E5E-AC5039454D8B" id="objIDCard" class="hidden" ></OBJECT>
		<div class="easyui-panel warp" data-options="border:false">


 	 		<div class="easyui-panel ui-search-panel" title="查询条件" data-options="striped: true,collapsible:true,iconCls:'icon-search'" style="width:98%;">
 	 			<form id="searchForm" method="post">
 	 			<p class="ui-fields">
 	 	    		<label class="ui-label">姓名：</label>
 	 	    		<input name="userLname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;  
 	 	    		<label class="ui-label">电话：</label>
 	 	    		<input name="userTelephone" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;   		              			 	    		 	    		
 	 	    		<label class="ui-label">单位：</label>
 	 	    		<input name="userDepname" type="text" class="ui-text">&nbsp;&nbsp;&nbsp;           		
            		<label class="ui-label">卡片状态：</label>
            		<select class="easyui-combobox" name="cardXh" data-options="width:100,height:23,panelHeight:72,editable:false">
	                	<option value="" selected="selected">-- 请选择 --</option>
	                  	<option value="0">卡使用中</option>
	                  	<option value="1">无卡使用中</option>
	                </select>&nbsp;&nbsp;&nbsp;
	               <label class="ui-label">登记|修改时间：</label>
            	   <input name="userSj" class="easyui-datebox" data-options="width:120,height:22,editable:false"></input>&nbsp;&nbsp;&nbsp;                  		
        		</p>
        		<a id="btn-search" href="#" class="easyui-splitbutton" iconCls="icon-search" menu="#menu-reset" plain="false">查询</a>
        		<div id="menu-reset">
				    <div id="btn-reset" iconCls="icon-reset">重置</div>
				</div>
      			</form>  
     		</div> 


     		<form id="listForm" method="post">
     			<table id="data-list"></table>
     		</form>


  	 		
  	 		<div id="edit-win" class="easyui-dialog" title="访客对话框" data-options="width:550,height:430,closed:true,iconCls:'icon-window',modal:true" buttons='#dlg-buttons'>  
     			<form id="editForm" class="ui-form" method="post" enctype="multipart/form-data">  
     			<input class="hidden" type="text" name="id">     	
     			<input class="hidden" type="text" name="userSerial">     	
     		 	<div class="ui-edit">
 					<div class="ftitle">访客信息</div>    	     	  
	     	  		<div class="left">
	     	  			<div class="fitem">  
		               		<label>姓名：</label>  
	               			<input name="userLname" id="username" class="easyui-validatebox ui-text" type="text" data-options="required:true,validType:'length[0,15]'" >
		           		</div>  	            
		          	 	<div class="fitem">  	
		          	 		<label>性别：</label>  
							<select name="userSex" id="userSex" class="easyui-combobox" data-options="width:120,height:23,panelHeight:48,editable:false">
	                   			<option value="男" selected="selected">男</option>
	                   			<option value="女">女</option>                   		
	                  		</select>		          	 	
	                  	</div> 	
		          	 	<div class="fitem">  	
		          	 		<label>民族：</label>  
	               			<select name="userNation" id="userNation" class="easyui-combobox" data-options="method:'get',url:'${msUrl}systemController/ttNationLoad.do',valueField:'value',textField:'text',width:120,height:22,panelHeight:120,editable:false,hasDownArrow:false"></select>
		          	 	</div> 	          		
		           		<div class="fitem">  
		           			<label>家庭地址：</label>  
	               			<input name="userAddress" id="userAddress" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,30]'" >
		           		</div> 	
		           		<div class="fitem">		           			
		               		<label>身份证号：</label>  
	               			<input name="userId" id="userId" class="easyui-validatebox ui-text" type="text" data-options="required:true,validType:'length[15,18]'" >
		           		</div> 	
		           		<div class="fitem"> 		           			
		           			<label>单位：</label>  
		               		<input name="userDepname" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,25]'">		               		
		           		</div>      		
		            </div>
		            <div class="right">	 
     	  				<div class="cover">
			        		<img id="img" alt="头像">
			        	</div>				    	
	     	  		</div>	 
	     	  		<div class="clear">
	     	  			<div class="fitem">  
		           			<label>电话：</label>  
	               			<input name="userTelephone" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,15]'">
		               		<label>邮箱：</label>  
	               			<input name="userEmail" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,25]'">
		           		</div>  	     	  				
		           		<div class="fitem">  
			               	<label>备注：</label>  
		               		<textarea name="userBz" class="easyui-validatebox" name="roleDes" data-options="validType:'length[0,50]'"></textarea>
			               	<span>不超过50字</span>
			           	</div> 
			           	<div class="fitem">  
		               		<label></label>  
		               		<input id="isContinue" checked type="checkbox" >去开卡
		           		</div> 
	     	  		</div>    	  			     	  		      	  		   	       	 	
	         	</div>
     			</form>
  	 		</div> 
  	 		
  	 		<div id="dlg-buttons">
  	 			<a id="btn-readIDCard" href="#" class="easyui-linkbutton">二代身份证</a>
  	 			<a id="btn-readIDCard2" href="#" class="easyui-linkbutton">一代身份证</a>
  	 			<a id="btn-readIDCard3" href="#" class="easyui-linkbutton">驾驶证</a>
  	 			<a id="btn-readIDCard4" href="#" class="easyui-linkbutton">军官证</a>
				<a id="btn-save" href="#" class="easyui-linkbutton">保存</a>
				<a id="btn-close" href="#" class="easyui-linkbutton">关闭</a>
			</div>
  	 		
  	 		<div id="edit-win2" class="easyui-dialog" title="开卡|退卡对话框" data-options="width:550,height:440,closed:true,iconCls:'icon-window',modal:true" buttons='#dlg-buttons2'>
  	 			<form id="editForm2" class="ui-form" method="post">  
     		 	<input id="userSerial" type="hidden" name="userSerial">  
     		 	<input id="cardHao" type="hidden" name="cardHao">     			    			
     		 	<div class="ui-edit">     		 		 
    		 		<div class="ftitle part">来访信息</div>
		           	<div class="fitem part"> 		           			
		               	<label>受访人员：</label>  
		               	<input name="visitorUser" class="easyui-validatebox ui-text" type="text" data-options="required:true,validType:'length[1,10]'">
		               	<label>受访人电话：</label>  
		               	<input name="visitorPhone" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,25]'">			
		           	</div> 		           		
		           	<div class="fitem part"> 	               		
		               	<label>受访部门：</label>  
		               	<select name="userDep" class="easyui-combotree" data-options="method:'get',url:'${msUrl}systemController/dtDepLoad.do',width:120,height:22,panelWidth:300,panelHeight:300,editable:false,animate:true,hasDownArrow:false,lines:true,required:true"></select>
		               	<label>来访是由：</label>  
		               	<input name="visitorReason" class="easyui-validatebox ui-text" type="text" data-options="validType:'length[0,25]'">
		           	</div>  	             	
		          	 <div class="fitem part">  
		               	<label>来访备注：</label>  
		               	<textarea name="visitorDes" class="easyui-validatebox" data-options="validType:'length[0,50]'"></textarea>
		               	<span>不超过50字</span>
		           	</div>		           	
     		 		<div class="ftitle">卡片操作信息</div>  		  
	           		<div class="fitem hidden">  
	               		<label>串口：</label>  
	               		<select id="port" class="easyui-combobox" data-options="method:'get',url:'port.json',valueField:'value',textField:'text',width:120,height:22,panelHeight:72,editable:false">
	               			<option value="3" selected="selected">3</option>
	               		</select>
	               		<label>发卡器类型：</label>  
	               		<select class="easyui-combobox" data-options="width:120,height:22,disabled:true">
	               			<option value="20000" selected="selected">IC卡(CS-6C)</option>
	               		</select>
	           		</div>      		 		  	           		       
	          	 	<div class="fitem">  
	               		<label>操作提示：</label>  
	               		<div class="readCardMessage"></div>
	           		</div>  
	           		</form>	              	       	 	
	         	</div>
     			
  	 		</div> 
  	 		
  	 		<div id="dlg-buttons2">
				<a id="btn-openCard" href="#" class="easyui-linkbutton">开卡</a>
				<a id="btn-returnCard" href="#" class="easyui-linkbutton">退卡</a>
				<a id="btn-close2" href="#" class="easyui-linkbutton">关闭</a>
			</div>

  	
		</div>
	</body>
</html>
