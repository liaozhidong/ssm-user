<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'showItems.jsp' starting page</title>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap-datetimepicker.min.css"/>
    <script type="text/javascript" src="/bootstrap/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>

</head>
<style>
    th {
        text-align: center;
    }

    td {
        text-align: center;
        margin: auto;
        padding: auto;
    }
</style>
<script type="text/javascript">
    $("#myModal").modal({
        keyboard: false,
        backdrop: true
    });
    $(function () {
        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:mm",
            autoclose: true,
            todayBtn: true,
            todayHighlight: true,
            showMeridian: true,
            pickerPosition: "bottom-left",
            language: 'zh-CN',//中文，需要引用zh-CN.js包
            startView: 2,//月视图
            minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
        });

        <%--Load();--%>

        <%--function Load() {--%>
        <%--$.ajax({--%>
        <%--type: "POST",--%>
        <%--url: "${pageContext.request.contextPath}/items/queryItems.action",--%>
        <%--dataType: "json",--%>
        <%--success: function (msg) {--%>
        <%--$.each(msg, function (index, item) {--%>
        <%--$("#itemsList").html(--%>
        <%--$("#itemsList").html() +--%>
        <%--"<tr>" +--%>
        <%--"<td>" + item.id + "</td>" +--%>
        <%--"<td>" + item.name + "</td>" +--%>
        <%--"<td>" + item.price + "</td>" +--%>
        <%--"<td>" + item.pic + "</td>" +--%>
        <%--"<td>" + item.detail + "</td>" +--%>
        <%--"</tr>"--%>
        <%--)--%>
        <%--$("#itemsList").append(item);--%>
        <%--});--%>
        <%--}--%>
        <%--});--%>
        <%--}--%>
    });
</script>
<body>
<div class="container">
    <!--标题-->
    <div class="col-md-7">
        <h1>用户列表</h1>
    </div>
    <!--注销-->
    <div class="col-md-offset-10">
        <h4>欢迎您：<span class="glyphicon glyphicon-user">
				<strong>${ user1.username }</strong>
			</span></h4>
        <a href="${pageContext.request.contextPath }/user/LogOut.action" style="text-decoration: none">
            <button type="button" class="btn btn-block"><span class="glyphicon glyphicon-off"></span>注销</button>
        </a>
    </div>
    <!--按钮-->
    <div class="row" style="padding-bottom: 10px;">
        <div class="col-sm-offset-6 col-md-offset-1">
            <button type="button" class="btn btn-primary" data-target="#myModal" data-toggle="modal">
                <span class="glyphicon glyphicon-plus"></span>添加商品
            </button>
        </div>
    </div>
    <!--表格-->
    <div class="row" style="padding-top: 10px">
        <div class="col-md-12">
            <form action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
                <table class="table table-bordered table-hover">
                    <tr class="info">
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>图片</th>
                        <th>商品介绍</th>
                        <th>生成日期</th>
                        <th colspan="3">操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="item">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td><img title="${item.detail}" style="width: 30px;height: 30px"
                                     src="${pageContext.request.contextPath}/upload/${item.pic}"></td>
                            <td>${item.detail}</td>
                            <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd:mm"/></td>
                            <td><a href="${pageContext.request.contextPath }/items/del.action?id=${item.id}">
                                <button type="button" class="btn btn-success btn-lg"
                                        onclick="return confirm('确认要删除信息') "><span
                                        class="glyphicon glyphicon-trash"></span> 删除
                                </button>
                            </a>
                                <a href="${pageContext.request.contextPath }/items/findOne.action?id=${item.id}">
                                <button type="button" class="btn btn-success btn-lg" id="update"><span
                                        class="glyphicon glyphicon-edit"></span> 修改
                                </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>

    <%--<table class="table table-hover table-striped table-bordered table-hover">--%>
    <%--<thead>--%>
    <%--<tr role="row" class="info">--%>
    <%--<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="text-align: center">商品名称</th>--%>
    <%--<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="text-align: center">商品价格</th>--%>
    <%--<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="text-align: center">图片</th>--%>
    <%--<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="text-align: center">商品介绍</th>--%>
    <%--<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="text-align: center">生成日期</th>--%>
    <%--<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="text-align: center">操作</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<tbody id="itemsList" style="text-align: center"/>--%>
    <%--</table>--%>

    <!--分页-->
    <div class="row">
        <!--分页信息-->
        <div class="col-md-6">
            <h4>当前第${pageInfo.pageNum},共${pageInfo.pages}页,共${pageInfo.total}条记录数</h4>
        </div>
        <!--分页条-->
        <div class="col-md-6">
            <ul class="pagination pagination-lg">
                <li><a href="${pageContext.request.contextPath}/items/queryItems.action?pn=1">首页</a></li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/items/queryItems.action?pn=${pageInfo.pageNum-1}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${pageInfo.navigatepageNums }" var="nav">
                    <c:if test="${nav==pageInfo.pageNum }">
                        <li class="active"><a
                                href="${pageContext.request.contextPath }/items/queryItems.action?pn=${nav}">${nav }</a>
                        </li>
                    </c:if>
                    <c:if test="${nav!=pageInfo.pageNum }">
                        <li><a href="${pageContext.request.contextPath }/items/queryItems.action?pn=${nav}">${nav }</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath }/items/queryItems.action?pn=${pageInfo.pageNum+1}"
                           aria-label="Previous">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="${pageContext.request.contextPath }/items/queryItems.action?pn=${pageInfo.pages}">末页</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<!--添加商品模态框-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">关闭</span></button>
                <h4 class="modal-title" id="myModalLabel">添加商品</h4>
            </div>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/items/addItems.action"
                  method="post" id="form" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group  form-group-lg">
                        <label class="col-sm-3 control-label">商品名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control input-lg" id="name" name="name" placeholder="请输入商品名字"
                                   required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">请输入商品价格</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control input-lg" id="price" name="price"
                                   placeholder="请输入商品价格" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">请输入商品生产日期</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control input-lg form_datetime" id="createtime"
                                   name="createtime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">请输入商品介绍</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control input-lg" id="detail" name="detail"
                                   placeholder="请输入商品介绍" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">请上传商品图片</label>
                        <div class="col-sm-5">
                            <input type="file" class="form-control input-lg" id="items_pic" name="items_pic">
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary" id="save">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!--加载页面数据-->
<script type="itemsListTemplate" type="x-tmpl-mustache">
       {{#itemsList}}
            <tr class="row" class="config odd" data-id="{{id}}">
                <td>{{name}}</td>
                <td>{{price}}</td>
                <td>{{detail}}</td>
                <td>{{pic}}</td>
                <td>{{createtime}}</td>
                <td>
                    <div class="hidden-sm hidden-xs action-buttons">
                         <a class="green exchange-edit" title="编辑" href="#" data-id="{{id}}">
                            <i class="ace-icon fa fa-pencil bigger-100"></i>
                        </a>
                        &nbsp;
                        <a class="red exchange-delete" title="删除" href="#" data-id="{{id}}" data-name="{{name}}">
                            <i class="ace-icon fa fa-trash-o bigger-100"></i>
                        </a>
                    </div>
                </td>
            </tr>
       {{/itemsList}}


</script>

<script type="text/javascript">
    $(function () {
        items.detail.init({});
    });
</script>
</body>
</html>
