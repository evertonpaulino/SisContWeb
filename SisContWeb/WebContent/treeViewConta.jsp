<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Basic TreeGrid - jQuery EasyUI Demo</title>

<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body>
	<h1>TreeGrid</h1>
	
	<a href="index.jsp">Home</a>
	
	<hr/>
	
	<table id="tg" title="Plano de Conta" class="easyui-treegrid" style="width: 650px; height: 800px"
		data-options="
					url: 'PlanoDeContaManter?operacao=listaConta',
						                
					rownumbers: true,
					idField:'codgReduzido',
					treeField:'conta',
					
	     			iconCls: 'icon-ok',  
	                animate: true,  
	                collapsible: true,  
	                fitColumns: true,
	                
	                onContextMenu: onContextMenu
				    ">
		<thead>
			<tr>
				<th data-options="field:'conta'" width="200">Conta</th>
				<th data-options="field:'descricao'" width="400">Descricao</th>
			</tr>
		</thead>
	</table>

	<div id="mm" class="easyui-menu" style="width: 120px;">
		<div onclick="novaConta()" data-options="iconCls:'icon-add'">Nova</div>
		<div onclick="editaConta()" data-options="iconCls:'icon-edit'">Edita</div>
		<div onclick="deletaConta()" data-options="iconCls:'icon-remove'">Deleta</div>
		<div class="menu-sep"></div>
		<div onclick="expand()" data-options="iconCls:'icon-redo'">Expandir Árvore</div>
		<div onclick="collapse()" data-options="iconCls:'icon-undo'">Encolher Árvore</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;" data-options="iconCls:'icon-save',	modal:true, closed:true, buttons:'#dlg-buttons'">  
    	<div class="ftitle">Informações da Conta</div>  
        <form id="fm" method="post" novalidate>  
            <div class="fitem">  
                <label>Conta Contábil:</label>  
                <input name="contaContabil" class="easyui-validatebox" data-options="required:true, missingMessage:'Campo Obrigatório'"/>
            </div>  
            <div class="fitem">  
                <label>Descrição:</label>  
                <input name="descricao" class="easyui-validatebox" data-options="required:true, missingMessage:'Campo Obrigatório'"/>
            </div>
		</form>

	</div>
	
    <div id="dlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton"  data-options="iconCls:'icon-ok'" onclick="salvaConta()">Salvar</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton"  data-options="iconCls:'icon-cancel'" onclick="javascript:$('#dlg').dialog('close')">Cancelar</a>  
    </div>  

	<script type="text/javascript">

		function onContextMenu(e, row) {
			e.preventDefault();
			$(this).treegrid('select', row.codgReduzido);
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
		}
		
		var url;  
		
		function novaConta(){
			var row = $('#tg').treegrid('getSelected');
			
			$('#dlg').dialog('open').dialog('setTitle', 'Nova Conta');
            $('#fm').form('clear');  
            url = 'PlanoDeContaManter?operacao=insert&contaPai=' + row.conta + '&contaPaiCodgReduzido=' + row.codgReduzido;
		}
		
        function editaConta(){  
            var row = $('#tg').treegrid('getSelected');  
            if (row){  
                $('#dlg').dialog('open').dialog('setTitle','Edita Conta');  
                $('#fm').form('load',row);  
                url = 'PlanoDeContaManter?operacao=edit&id='+row.codgReduzido;  
            }  
        }  
        function salvaConta(){  
            $('#fm').form('submit',{
                url: url,  
            	onSubmit: function(){
            		var isValid = $(this).form('validate');
            		if (!isValid){
            			$.messager.progress('close');	// hide progress bar while the form is invalid
            		}
            		return isValid;	// return false will stop the form submission
            	},
            	success: function(result){
            		var result = eval('('+result+')');
            		
            		appendConta(result);
            		
            		$('#dlg').dialog('close');      // close the dialog  
            		$.messager.progress('close');	// hide progress bar while submit successfully
            	}
            });  
        }  

		function appendConta(node) {
			
			$('#tg').treegrid('append', {
				parent : node.contaPaiCodgReduzido,
				data : [ {
					codgReduzido: node.codgReduzido,
					conta: node.conta,
					descricao: node.descricao
				} ]
			});
		}

		function deletaConta(){  
            var row = $('#tg').treegrid('getSelected');
            if (row){
                $.messager.confirm('Confirmação','Tem certeza de que quer destruir esta conta?',function(r){
                    if (r){
                        $.post('PlanoDeContaManter?operacao=delete',{codgReduzido:row.codgReduzido},function(){  
                        	//$('#tg').treegrid('reload');    // reload the user data
                        	$('#tg').treegrid('remove', row.codgReduzido);
                        },'json');  
                    }  
                });  
            }  
        }  		

		function remove() {
			var node = $('#tg').treegrid('getSelected');
			if (node) {
				$('#tg').treegrid('remove', node.codgReduzido);
			}
		}
		
		function collapse() {
			var node = $('#tg').treegrid('getSelected');
			if (node) {
				$('#tg').treegrid('collapse', node.codgReduzido);
			}
		}
		
		function expand() {
			var node = $('#tg').treegrid('getSelected');
			if (node) {
				$('#tg').treegrid('expand', node.codgReduzido);
			}
		}
		
	</script>
	
	<style type="text/css">  
        #fm{  
            margin:0;  
            padding:10px 30px;  
        }  
        .ftitle{  
            font-size:14px;  
            font-weight:bold;  
            color:#666;  
            padding:5px 0;  
            margin-bottom:10px;  
            border-bottom:1px solid #ccc;  
        }  
        .fitem{  
            margin-bottom:5px;  
        }  
        .fitem label{  
            display:inline-block;  
            width:80px;  
        }  
    </style>  
	

</body>
</html>