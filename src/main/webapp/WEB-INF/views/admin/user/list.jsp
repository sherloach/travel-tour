<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="emplAPI" value="/api/empl"/>
<c:url var="emplURL" value="/admin/empl/list"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<div class="page has-sidebar-left height-full">
		<header class="blue accent-3 relative">
			<div class="container-fluid text-white">
				<div class="row p-t-b-10 ">
					<div class="col">
						<h4>
							<i class="icon-database"></i> Users
						</h4>
					</div>
				</div>
				<div class="row justify-content-between">
					<ul class="nav nav-material nav-material-white responsive-tab"
						id="v-pills-tab" role="tablist">
						<li><a class="nav-link active" id="v-pills-all-tab"
							data-toggle="pill" href="<c:url value='/admin/empl/list?page=1&limit=6'/>" role="tab"
							aria-controls="v-pills-all"><i class="icon icon-home2"></i>All
								Users</a></li>
						<li class="float-right"><a class="nav-link"
							href="<c:url value='/admin/empl/edit'/>"><i
								class="icon icon-plus-circle"></i> Add New User</a></li>
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
													<th>NAME</th>
													<th>BIRTHDAY</th>
													<th>GENDER</th>
													<th>ADDRESS</th>
													<th>PHONE</th>
													<th>STATUS</th>
													<th>ROLE</th>
													<th></th>
												</tr>
											</thead>

											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td>
															<div class="avatar avatar-md mr-3 mt-1 float-left">
																<span class="avatar-letter avatar-letter-a  avatar-md circle">
																	<img class="user_avatar" src="${pageContext.request.contextPath}/template/upload/${item.avatar}" alt="User Image">
																</span>
															</div>
															<div>
																<div>
																	<strong>${item.name}</strong>
																</div>
																<small> ${item.email}</small>
															</div>
														</td>

														<td>${item.birthday}</td>
														<td>${item.gender ? 'Nam' : 'Nữ'}</td>
														<td>${item.address}</td>

														<td>${item.phoneNumber}</td>
														<td>
															<c:if test="${item.status == 1}">
																<span class="icon icon-circle s-12  mr-2 text-success"></span>
																Active
															</c:if>
															<c:if test="${item.status == 0}">
																<span class="icon icon-circle s-12  mr-2 text-danger"></span>
																Leave
															</c:if>
														</td>
														<td>
															<c:if test="${item.role == 'ADMIN'}">
																<span class="r-3 badge badge-warning">${item.role}</span>
															</c:if>
															<c:if test="${item.role == 'EMPLOYEE'}">
																<span class="r-3 badge badge-success">${item.role}</span>
															</c:if>
														</td>
														<!-- Update User -->
														<c:url var="updateEmplURL" value="/admin/empl/edit">
															<c:param name="id" value="${item.id}"/>
														</c:url>
														<td>
															<c:if test="${item.status != 0}">
																<a href="${updateEmplURL}"><i class="icon-pencil mr-3"></i></a>
																<a href="#" onclick="warningBeforeDelete(${item.userID})"><i class="icon-trash-can4"></i></a>
															</c:if>	
														</td>
													</tr>
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

	<script type="text/javascript">
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

		function warningBeforeDelete(userID) {
			swal({
			  title: "Are you sure?",
			  text: "You will not be able to recover this user!",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "Delete",
			  cancelButtonText: "Cancel",
			}).then(function(isConfirm) {
			  if (isConfirm.dismiss !== 'cancel') {
					deleteTour(userID);
			  }
			});
		}

		function deleteTour(data) {
	        $.ajax({
	            url: '${emplAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${emplURL}?page=1&limit=6&message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${emplURL}?page=1&limit=2&message=error_system";
	            }
	        });
	    }
	</script>
</body>
</html>