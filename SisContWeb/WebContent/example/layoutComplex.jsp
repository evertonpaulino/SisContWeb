<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%-- 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
--%>

<!DOCTYPE html>  
<html>  
<head>  
    <meta charset="UTF-8">  
    <title>Complex Layout - jQuery EasyUI Demo</title>  
    
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">  
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">  
    <%--
     <link rel="stylesheet" type="text/css" href="../demo.css">  
     --%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>  
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    
</head>  
<body>  
    <h2>Complex Layout</h2>  
    <div class="demo-info">  
        <div class="demo-tip icon-tip"></div>  
        <div>This sample shows how to create a complex layout.</div>  
    </div>  
    <div style="margin:10px 0;"></div>  
    <div class="easyui-layout" style="width:700px;height:350px;">  
        <div data-options="region:'north'" style="height:50px"></div>  
        <div data-options="region:'south',split:true" style="height:50px;"></div>  
        <div data-options="region:'east',split:true" title="East" style="width:180px;">  
            <ul class="easyui-tree" data-options="url:'tree/tree_data1.json',animate:true,dnd:true"></ul>  
        </div>  
        <div data-options="region:'west',split:true" title="West" style="width:100px;">  
            <div class="easyui-accordion" data-options="fit:true,border:false">  
                <div title="Title1" style="padding:10px;">  
                    content1  
                </div>  
                <div title="Title2" data-options="selected:true" style="padding:10px;">  
                    content2  
                </div>  
                <div title="Title3" style="padding:10px">  
                    content3  
                </div>  
            </div>  
        </div>  
        <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">  
            <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">  
                <div title="About" data-options="href:'panel/Content.jsp'" style="padding:10px"></div>  
                <div title="DataGrid" style="padding:5px">  
                    <table class="easyui-datagrid"  
                            data-options="url:'datagrid/datagrid_data1.json',singleSelect:true,fit:true,fitColumns:true">  
                        <thead>  
                            <tr>  
                                <th data-options="field:'itemid'" width="80">Item ID</th>  
                                <th data-options="field:'productid'" width="100">Product ID</th>  
                                <th data-options="field:'listprice',align:'right'" width="80">List Price</th>  
                                <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>  
                                <th data-options="field:'attr1'" width="150">Attribute</th>  
                                <th data-options="field:'status',align:'center'" width="50">Status</th>  
                            </tr>  
                        </thead>  
                    </table>  
                </div>  
            </div>  
        </div>  
    </div>  
</body>  
</html>  