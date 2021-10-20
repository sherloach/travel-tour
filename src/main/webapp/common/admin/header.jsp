<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.nqhtour.util.SecurityUtils"%>
<!-- Pre loader -->
<div id="loader" class="loader">
	<div class="plane-container">
		<div class="preloader-wrapper small active">
			<div class="spinner-layer spinner-blue">
				<div class="circle-clipper left">
					<div class="circle"></div>
				</div><div class="gap-patch">
				<div class="circle"></div>
			</div><div class="circle-clipper right">
				<div class="circle"></div>
			</div>
			</div>

			<div class="spinner-layer spinner-red">
				<div class="circle-clipper left">
					<div class="circle"></div>
				</div><div class="gap-patch">
				<div class="circle"></div>
			</div><div class="circle-clipper right">
				<div class="circle"></div>
			</div>
			</div>

			<div class="spinner-layer spinner-yellow">
				<div class="circle-clipper left">
					<div class="circle"></div>
				</div><div class="gap-patch">
				<div class="circle"></div>
			</div><div class="circle-clipper right">
				<div class="circle"></div>
			</div>
			</div>

			<div class="spinner-layer spinner-green">
				<div class="circle-clipper left">
					<div class="circle"></div>
				</div><div class="gap-patch">
				<div class="circle"></div>
			</div><div class="circle-clipper right">
				<div class="circle"></div>
			</div>
			</div>
		</div>
	</div>
</div>
<div id="app">
	<aside class="main-sidebar fixed offcanvas shadow"
		data-toggle='offcanvas'>
		<section class="sidebar">
			<div class="w-80px mt-3 mb-3 ml-3">
				<img src="/template/admin/assets/img/basic/logo-green.png" alt="">
			</div>
			<div class="relative">
				<a data-toggle="collapse" href="#userSettingsCollapse" role="button"
					aria-expanded="false" aria-controls="userSettingsCollapse"
					class="btn-fab btn-fab-sm absolute fab-right-bottom fab-top btn-primary shadow1 ">
					<i class="icon icon-cogs"></i>
				</a>
				<div class="user-panel p-3 light mb-2">
					<div>
						<div class="float-left image">
							<img class="user_avatar" src="${pageContext.request.contextPath}/template/upload/${item.avatar}" alt="User Image">
						</div>
						<div class="float-left info">
							<h6 class="font-weight-light mt-2 mb-1"><%=SecurityUtils.getPrincipal().getFullName()%></h6>
							<a href="#"><i class="icon-circle text-primary blink"></i>
								Online</a>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="collapse multi-collapse" id="userSettingsCollapse">
						<div class="list-group mt-3 shadow">
							<a href="index.html"
								class="list-group-item list-group-item-action "> <i
								class="mr-2 icon-umbrella text-blue"></i>Profile
							</a> <a href="#" class="list-group-item list-group-item-action"><i
								class="mr-2 icon-cogs text-yellow"></i>Settings</a> <a href="#"
								class="list-group-item list-group-item-action"><i
								class="mr-2 icon-security text-purple"></i>Change Password</a>
						</div>
					</div>
				</div>
			</div>
			<ul class="sidebar-menu">
				<li class="header"><strong>MAIN NAVIGATION</strong></li>
				<li class="treeview">
					<a href="#">
						<i class="icon icon icon-add_location blue-text s-18"></i>Routes<i
							class="icon icon-angle-left s-18 pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li>
							<a href="<c:url value='/admin/route/list?page=1&limit=6'/>">
							<i class="icon icon-circle-o"> </i>All Routes</a>
						</li>
					</ul>
				</li>
				<li class="treeview"><a href="#"> <i
						class="icon icon icon-card_travel blue-text s-18"></i>Tours<i
						class="icon icon-angle-left s-18 pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a
							href="<c:url value='/admin/tour/list?page=1&limit=6'/>"><i
								class="icon icon-circle-o"> </i>All Tours</a></li>
						<li><a href="<c:url value='/admin/tour/edit'/>"><i
								class="icon icon-add"> </i>Add New </a></li>
					</ul></li>
				<li class="treeview"><a href="#"><i
						class="icon icon-account_box light-green-text s-18"></i>Users<i
						class="icon icon-angle-left s-18 pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="<c:url value='/admin/empl/list?page=1&limit=6'/>"><i
							class="icon icon-circle-o"></i>All Users</a></li>
					<li><a href="<c:url value='/admin/empl/edit'/>"><i
							class="icon icon-add"></i>Add User</a></li>
				</ul></li>
				<li class="treeview"><a href="#"><i
						class="icon icon-account_balance_wallet light-green-text s-18"></i>Bookings<i
						class="icon icon-angle-left s-18 pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="<c:url value='/admin/booking/list'/>"><i
								class="icon icon-circle-o"></i>All Bookings</a></li>
<%--						<li><a href="<c:url value='/admin/booking/list/invoice'/>"><i--%>
<%--								class="icon icon-add"></i>All Invoices</a></li>--%>
					</ul></li>
				<li class="treeview"><a href="#"><i
						class="icon icon-area-chart light-green-text s-18"></i>Reports<i
						class="icon icon-angle-left s-18 pull-right"></i></a>
					<ul class="treeview-menu">
						<li><a href="<c:url value='/admin/report/revenue?month=10&year=2021'/>"><i
								class="icon icon-bar-chart-o pink-text s-18"></i>Revenue By Month</a></li>
						<li><a href="<c:url value='/admin/booking/list/invoice'/>"><i
								class="icon icon-bar-chart2 pink-text s-18"></i>All Invoices</a></li>
					</ul></li>
			</ul>
		</section>
	</aside>
	<!--Sidebar End-->
	<div class="has-sidebar-left">
		<div class="pos-f-t">
			<div class="collapse" id="navbarToggleExternalContent">
				<div class="bg-dark pt-2 pb-2 pl-4 pr-2">
					<div class="search-bar">
						<input
							class="transparent s-24 text-white b-0 font-weight-lighter w-128 height-50"
							type="text" placeholder="start typing...">
					</div>
					<a href="#" data-toggle="collapse"
						data-target="#navbarToggleExternalContent" aria-expanded="false"
						aria-label="Toggle navigation"
						class="paper-nav-toggle paper-nav-white active "><i></i></a>
				</div>
			</div>
		</div>
		<div class="sticky">
			<div
				class="navbar navbar-expand navbar-dark d-flex justify-content-between bd-navbar blue accent-3">
				<div class="relative">
					<a href="#" data-toggle="push-menu"
						class="paper-nav-toggle pp-nav-toggle"> <i></i>
					</a>
				</div>
				<!--Top Menu Start -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li><a class="nav-link " data-toggle="collapse"
							data-target="#navbarToggleExternalContent"
							aria-controls="navbarToggleExternalContent" aria-expanded="false"
							aria-label="Toggle navigation"> <i class=" icon-search3 "></i>
						</a></li>
						<!-- User Account-->
						<li class="dropdown custom-dropdown user user-menu "><a
							href="#" class="nav-link" data-toggle="dropdown"> <img
								src="#" class="user-image" alt="User Image"> <i
								class="icon-more_vert "></i>
						</a>
							<div class="dropdown-menu p-4 dropdown-menu-right">
								<div class="row box justify-content-between my-4">
									<div class="col">
										<a href="#"> <i
											class="icon-beach_access pink lighten-1 avatar  r-5"></i>
											<div class="pt-1">Profile</div>
										</a>
									</div>
									<div class="col">
										<a href="#"> <i
											class="icon-perm_data_setting indigo lighten-2 avatar  r-5"></i>
											<div class="pt-1">Settings</div>
										</a>
									</div>
									<div class="col">
										<a href='<c:url value='/logout'/>'> <i
											class="icon-sign-out orange lighten-2 avatar  r-5"></i>
											<div class="pt-1">Logout</div>
										</a>
									</div>
								</div>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>