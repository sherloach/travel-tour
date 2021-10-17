<%--
  Created by IntelliJ IDEA.
  User: NQH
  Date: 10/4/2021
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>All Routes</title>
</head>
<body>
    <div class="page has-sidebar-left height-full">
        <header class="blue accent-3 relative">
            <div class="container-fluid text-white">
                <div class="row p-t-b-10 ">
                    <div class="col">
                        <h4>
                            <i class="icon-database"></i> Routes
                        </h4>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <ul class="nav nav-material nav-material-white responsive-tab"
                        id="v-pills-tab" role="tablist">
                        <li class="float-right"><a class="nav-link" href="<c:url value='/admin/empl/edit'/>">
                            <i class="icon icon-plus-circle"></i> Add New Route</a></li>
                    </ul>
                </div>
            </div>
        </header>

        <c:if test="${not empty message}">
            <div role="alert" class="alert alert-${alert}">
                <strong>${message}</strong>
            </div>
        </c:if>
        <form action="<c:url value='/admin/empl/list'/>" id="formSubmit" method="get">
            <div class="container-fluid animatedParent animateOnce">
                <div class="tab-content my-3" id="v-pills-tabContent">
                    <div class="tab-pane animated fadeInUpShort show active"
                         id="v-pills-all" role="tabpanel" aria-labelledby="v-pills-all-tab">
                        <div class="row my-3">
                            <div class="col-md-12">
                                <div class="card r-0 shadow">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover my-user-list-table r-0">
                                            <thead>
                                                <tr class="no-b my-user-list">
                                                    <th>START LOCATION</th>
                                                    <th>DESTINATION</th>
                                                    <th>TOURS</th>
                                                    <th></th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach var="item" items="${model.listResult}">
                                                <tr>
                                                    <td style="text-align: center;">${item.startLocation}</td>
                                                    <td>${item.destination}</td>
                                                    <td>${item.tourQuantity} Tours</td>
                                                    <td>
                                                        <a href='/admin/route/list/tour?route=${item.id}' class="my-btn-tour my-btn-tour-delete btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-note-list"></i></a>
                                                    </td>
                                                </tr
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <nav aria-label="Page navigation">
                            <ul class="pagination" id="pagination"></ul>
                            <input type="hidden" value="" id="page" name="page"/>
                            <input type="hidden" value="" id="limit" name="limit"/>
                        </nav>
                    </div>
                </div>
            </div>
        </form>

        <!--Add New Message Fab Button-->
        <a href="panel-page-users-create.html"
           class="btn-fab btn-fab-md fab-right fab-right-bottom-fixed shadow btn-primary"><i
                class="icon-add"></i></a>
    </div>

    <script>
        var totalPages = ${model.totalPage};
        var currentPage = ${model.page};
        $(function() {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages : totalPages,
                visiblePages : 10,
                startPage: currentPage,
                onPageClick : function(event, page) { // page là trang tiếp theo
                    if (currentPage != page) {
                        $('#limit').val(6);
                        $('#page').val(page);
                        $('#formSubmit').submit();
                    }
                }
            });
        });
    </script>
</body>
</html>
