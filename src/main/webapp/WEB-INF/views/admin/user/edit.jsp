<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="listUserURL" value="/admin/empl/list"/>
<c:url var="userAPI" value="/api/empl"/>
<c:url var="editUserURL" value="/admin/empl/edit"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<div class="page has-sidebar-left height-full">
    <header class="blue accent-3 relative">
        <div class="container-fluid text-white">
            <div class="row p-t-b-10 ">
                <div class="col">
                    <h4>
                        <i class="icon-database"></i>
                        Users
                    </h4>
                </div>
            </div>
            <div class="row justify-content-between">
                <ul class="nav nav-material nav-material-white responsive-tab" id="v-pills-tab" role="tablist">
                    <li>
                        <a class="nav-link" href="<c:url value='/admin/empl/list?page=1&limit=6'/>"><i class="icon icon-home2"></i>All Users</a>
                    </li>
                    <li>
                        <a class="nav-link active"  href="panel-page-users-create.html" ><i class="icon icon-plus-circle"></i> Add New User</a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <c:if test="${not empty message}">
		<div role="alert" class="alert alert-${alert}">
			  <strong>${message}</strong>
		</div>
	</c:if>
    <div class="container-fluid animatedParent animateOnce">
        <div class="animated fadeInUpShort">
            <div class="row my-3">
                <div class="col-md-7  offset-md-2">
                    <form:form id="formSubmit" role="form" modelAttribute="model">
                        <div class="card no-b  no-r">
                            <div class="card-body">
                                <h5 class="card-title">About User</h5>
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <div class="form-group m-0">
                                            <label class="col-form-label s-12">NAME</label>
                                            <form:input path="name" cssClass="form-control r-0 light s-12 " type="text" required="required"/>
                                        </div>

                                        <div class="form-row">
                                            <div class="form-group col-6 m-0">
                                                <label class="col-form-label s-12">GENDER</label>
												<br>
												<div class="custom-control custom-radio custom-control-inline">
													<%-- <form:input type="radio" path="male" name="gender" class="custom-control-input"/> --%>
													<form:radiobutton path="gender" value="true" label="Male"/>
													<!-- <label class="custom-control-label m-0" for="male">Male</label> -->
												</div>
												<div class="custom-control custom-radio custom-control-inline">
													<!-- <input type="radio" id="female" name="gender" class="custom-control-input"> -->
													<form:radiobutton path="gender" value="false" label="Female"/>
													<!-- <label class="custom-control-label m-0" for="female">Female</label> -->
												</div>
                                            </div>
                                            <div class="form-group col-6 m-0">
                                                <label class="col-form-label s-12"><i class="icon-calendar mr-2"></i>DATE OF BIRTH</label>
                                                <form:input path="birthday" placeholder="Select Date of Birth" cssClass="form-control r-0 light s-12 date-time-picker"
                                                data-options="{&quot;timepicker&quot;:false, &quot;format&quot;:&quot;Y-m-d&quot;}" type="text" required="required"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 offset-md-1">
                                        <input hidden id="file" name="file"/>
                                        <div class="dropzone dropzone-file-area pt-4 pb-4" id="fileUpload">
                                            <div class="dz-default dz-message">
                                                <span>Drop A passport size image of user</span>
                                                <div>You can also click to open file browser</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row mt-1">
                                    <div class="form-group col-6 m-0">
                                        <label class="col-form-label s-12"><i class="icon-envelope-o mr-2"></i>Email</label>
                                        <form:input path="email" placeholder="user@email.com" cssClass="form-control r-0 light s-12 " type="text" required="required"/>
                                    </div>

                                    <div class="form-group col-6 m-0">
                                        <label class="col-form-label s-12"><i class="icon-key4 mr-2"></i>Password</label>
                                        <form:password showPassword="true" path="password" cssClass="form-control r-0 light s-12 " required="required"/>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-6 m-0">
                                        <label class="col-form-label s-12">Address</label>
                                        <form:input path="address" type="text" cssClass="form-control r-0 light s-12" required="required"/>
                                    </div>
                                    <div class="form-group col-6 m-0">
                                        <label class="col-form-label s-12"><i class="icon-phone mr-2"></i>Phone</label>
                                        <form:input path="phoneNumber" cssClass="form-control r-0 light s-12 " type="text" required="required"/>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="card-body">
                                <h5 class="card-title">ROLE</h5>
                                <div class="form-row">
                                    <div class="form-group col-5 m-0">
                                        <label class="my-1 mr-2">Select a role</label>
                                        <form:select path="role" cssClass="custom-select my-1 mr-sm-2 form-control r-0 light s-12" required="required">
											<form:option value="NONE" label="Choose..."/>
											<form:option value="ADMIN" label="Admin"/>
											<form:option value="EMPLOYEE" label="Employee"/>
										</form:select>
                                    </div>
                                </div>
                                <!-- <a href="#" class="btn btn-primary bg-primary btn-sm mt-2">Add New Guardian</a> -->
                            </div>
                            <hr>
                            <!-- Cần phải có ID để xử lý thêm, sửa -->
							<form:hidden path="id" id="emplID"/>
							<form:hidden path="userID" id="userID"/>
                            <div class="card-body">
                                <button type="button" id="btnAddOrUpdateUser" class="btn btn-primary btn-lg"><i class="icon-save mr-2"></i>Save Data</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
		</div>
    </div>
</div>

<script type="text/javascript">
	(function () {
		"use strict";
		window.addEventListener("load", function () {
			var form = document.getElementById("formSubmit");
			var btnPublish = document.getElementById("btnAddOrUpdateUser");
			btnPublish.addEventListener("click", function (event) {
				event.preventDefault(); // Huỷ bỏ event nếu nó có thể huỷ mà không dừng sự lan rộng (propagation) của event tới phần khác.

				form.classList.add("was-validated");
				/* var editorElement = document.getElementById("description");
				if (editorElement.value == '') {
					editorElement.parentNode.classList.add("is-invalid");
					editorElement.parentNode.classList.remove("is-valid");
				} else {
					editorElement.parentNode.classList.remove("is-invalid");
					editorElement.parentNode.classList.add("is-valid");
				} */
				
				if (form.checkValidity() == true) { // Returns true if an input element contains valid data.
					event.stopPropagation(); // Ngăn chặn sự lan rộng của sự kiện hiện tại tới thằng khác.

					// TODO: fix validation
					// THÊM / SỬA
					event.preventDefault();
					var data = {};
					var formData = $('#formSubmit').serializeArray();
					$.each(formData, function (i, v) {
						data[""+v.name+""] = v.value;
					});

					var id = $('#emplID').val();
					if (id == "") {
						addUser(data);
					} else {
						updateUser(data);
					}
				}
			}, false);

			function addUser(data) {
				$.ajax({
					url: '${userAPI}',
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function (result) {
						window.location.href = "${editUserURL}?id=" + result.id + "&message=insert_success";
					},
					error: function (error) {
						window.location.href = "${listUserURL}?page=1&limit=6&message=error_system";
					}
				});
			}

			function updateUser(data) {
				$.ajax({
					url: '${userAPI}',
					type: 'PUT',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function (result) {
						window.location.href = "${editUserURL}?id=" + result.id + "&message=update_success";
					},
					error: function (error) {
						window.location.href = "${listUserURL}?page=1&limit=6&message=error_system";
					}
				});
			}
		}, false);
	}());
</script>

</body>
</html>