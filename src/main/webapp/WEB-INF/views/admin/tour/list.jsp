<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
							href="<c:url value='/admin/tour/list?page=1&limit=2'/>"><i class="icon icon-list"></i>All Tours</a></li>
						<li><a class="nav-link"
							href="<c:url value='/admin/tour/edit'/>">
							<i class="icon icon-plus-circle"></i> Add New Tours</a></li>
						<li><a class="nav-link" href="#"><i
								class="icon icon-trash-can"></i>Trash</a></li>
					</ul>
				</div>
			</div>
		</header>
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
														<td class="w-10"><img src="#" alt=""></td>
														<td>
															<h6>${item.name}</h6>
															<small class="text-muted">Mobile Phones</small>
														</td>
														<td>$${item.price}</td>
														<td><span class="badge badge-success">Published</span></td>
														<td><span><i class="icon icon-data_usage"></i>
																${item.duration} days</span><br> <span><i
																class="icon icon-timer"></i> ${item.startDate}</span></td>
														<td><a
															class="btn-fab btn-fab-sm btn-primary shadow text-white"><i
																class="icon-pencil"></i></a></td>
													</tr>
												</c:forEach>
												<tr class="no-b">
													<td class="w-10"><img src="#" alt=""></td>
													<td>
														<h6>Apple Product</h6> <small class="text-muted">Mobile
															Phones</small>
													</td>
													<td>$250</td>
													<td><span class="badge badge-success">Published</span></td>
													<td><span><i class="icon icon-data_usage"></i>
															5 days ago</span><br> <span><i
															class="icon icon-timer"></i> 5 September, 2017</span></td>
													<td><a
														class="btn-fab btn-fab-sm btn-primary shadow text-white"><i
															class="icon-pencil"></i></a></td>
												</tr>
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
	            		$('#limit').val(2);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>

</body>
</html>