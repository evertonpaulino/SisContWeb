<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <meta name="keywords" content="jquery,ui,easy,easyui,web">  
    <meta name="description" content="easyui help you build your web page easily!">  

    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">  
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">  
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">  
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>  
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>  
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.edatagrid.js"></script>
      
	<title>SisCont Web</title>
</head>  
<body>  
	<a href="index.jsp">Home</a>
	<hr/>
    <h2>Note de Entrada</h2>  
    <div class="demo-info" style="margin-bottom:10px">  
        <div class="demo-tip icon-tip">&nbsp;</div>  
        <div>Duplo clique na linha para editar.</div>  
    </div>  
     
    <table id="dg" title="Notas de Entrada" style="width:1200px;height:350px"  
            toolbar="#toolbar" pagination="true" idField="id"  
            rownumbers="true" fitColumns="true" singleSelect="true">  
        <thead>  
            <tr>  
                <th field="sequencial" width="40">Sequencial</th>  
                <th field="descricao" width="250" editor="{type:'validatebox',options:{required:true}}">Descricao</th>  
                <th field="dataEmissao" width="60" editor="datebox">Data de Emissão</th>  
                <th field="valor" width="50" editor="{type:'validatebox',options:{required:true}}">Valor</th>
                <th field="status" width="30" editor="text">Status</th>  
            </tr>  
        </thead>  
    </table>
    <div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">Novo</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">Delete</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">Salvar</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancelar</a>  
    </div>
    <script type="text/javascript">  
        $(function(){  
            $('#dg').edatagrid({
                url: 'NotaDeEntradaManter?operacao=listaNotas',
                saveUrl: 'NotaDeEntradaManter?operacao=insert',
                updateUrl: 'NotaDeEntradaManter?operacao=edit',
                destroyUrl: 'NotaDeEntradaManter?operacao=delete'
            });
        });  
    </script>  
      
</body>  
</html>