<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="tourAPI" value="/api/tour"/>
<c:url var="tourURL" value="/admin/tour/list"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Tours</title>
</head>
<body>
	<div class="page has-sidebar-left">
		<header class="blue accent-3 relative">
			<div class="container-fluid text-white">
				<div class="row p-t-b-10 ">
					<div class="col">
						<h4>
							<i class="icon-package"></i> Tours
						</h4>
					</div>
				</div>
				<div class="row">
					<ul class="nav responsive-tab nav-material nav-material-white">
						<li><a class="nav-link active"
							href="<c:url value='/admin/tour/list?page=1&limit=6'/>"><i class="icon icon-list"></i>All Tours</a></li>
						<li><a class="nav-link"
							href="<c:url value='/admin/tour/edit'/>">
							<i class="icon icon-plus-circle"></i> Add New Tours</a></li>
					</ul>
				</div>
			</div>
		</header>
		<c:if test="${not empty message}">
			<div role="alert" class="alert alert-${alert}">
				  <strong>${message}</strong>
			</div>
		</c:if>
		<form action="<c:url value='/admin/tour/list'/>" id="formSubmit" method="get">
			<div class="container-fluid animatedParent animateOnce my-3">
				<div class="animated fadeInUpShort">
					<div class="row">
						<div class="col-md-12">
							<div class="card no-b shadow">
								<div class="card-body p-0">
									<div class="table-responsive">
										<table class="table table-hover ">
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr class="no-b">
														<td class="w-10"><img src="${pageContext.request.contextPath}/template/upload/tour/${item.imageCover}" alt=""></td>
														<td> <h6>${item.name}</h6><small class="text-muted">Du Lịch Trong Nước</small> </td>
														<td><fmt:formatNumber value="${item.price}" type="currency" currencySymbol=""/> VND</td>
														<td><span class="badge badge-success">Published</span></td>
														<td><span><i class="icon icon-data_usage"></i> ${item.duration} days</span><br>
															<span><i class="icon icon-timer"></i> ${item.startDate}</span> </td>

														<!-- Update Tour -->
														<c:url var="updateTourURL" value="/admin/tour/edit">
															<c:param name="id" value="${item.id}"/>
														</c:url>
														<td>
															<a href='${updateTourURL}' class="my-btn-tour btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-pencil"></i></a>
															<c:if test="${model.currentGroupSize == 0}">
																<a href='#' onclick="warningBeforeDelete(${item.id})" class="my-btn-tour my-btn-tour-delete btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-trash-can"></i></a>
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
					</div>
					<nav aria-label="Page navigation">
						<ul class="pagination" id="pagination"></ul>
						<input type="hidden" value="" id="page" name="page"/>
						<input type="hidden" value="" id="limit" name="limit"/>	
					</nav>
				</div>
			</div>
		</form>
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

		function warningBeforeDelete(tourID) {
			swal({
			  title: "Are you sure?",
			  text: "You will not be able to recover this tour!",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-success",
			  cancelButtonClass: "btn-danger",
			  confirmButtonText: "Delete",
			  cancelButtonText: "Cancel",
			}).then(function(isConfirm) {
			  if (isConfirm.dismiss !== 'cancel') {
					//var ids = $('tbody input[type=checkbox]:checked').map(function () {
			        //   return $(this).val();
			        //}).get();
					//var id = $(this).data("value");
				  	var data = "{\"tourId\": " + tourID + " }";
					deleteTour(data);
			  }
			});
		}

		function deleteTour(data) {
	        $.ajax({
	            url: '${tourAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${tourURL}?page=1&limit=6&message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${tourURL}?page=1&limit=6&message=delete_people_failed";
	            }
	        });
	    }
	</script>

</body>
</html>