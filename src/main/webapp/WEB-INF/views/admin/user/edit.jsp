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
	<style>
		.error {
		  width  : 100%;
		  padding: 0;

		  font-size: 80%;
		  color: white;
		  background-color: #900;
		  border-radius: 0 0 5px 5px;

		  box-sizing: border-box;
		}

		.error.active {
		  padding: 0.3em;
		}
		
		.my-error {
		  border-color: #ed5564 !important;
		  padding-right: calc(1.5em + .75rem);
		  background-image: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' fill='%23ED5564' viewBox='-2 -2 7 7'%3e%3cpath stroke='%23ED5564' d='M0 0l3 3m0-3L0 3'/%3e%3ccircle r='.5'/%3e%3ccircle cx='3' r='.5'/%3e%3ccircle cy='3' r='.5'/%3e%3ccircle cx='3' cy='3' r='.5'/%3e%3c/svg%3E) !important;
		  background-repeat: no-repeat;
		  background-position: center right calc(.375em + .1875rem);
		  background-size: calc(.75em + .375rem) calc(.75em + .375rem) !important;
		}
	</style>
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
                                                data-options="{&quot;timepicker&quot;:false, &quot;format&quot;:&quot;Y-m-d&quot;, &quot;minDate&quot;:&quot;-1999/01/10&quot;, &quot;maxDate&quot;:&quot;+1953/01/10&quot;}" type="text" required="required" readonly="true" autocomplete="off"/>
                                            <!-- , &quot;minDate&quot;:&quot;-1970/01/02&quot; -->
                                            </div>
                                        </div>
                                    </div>
										<div class="col-md-3 offset-md-1" style="margin-left: 2rem;">
											<input id="uploadImage" name="file" type="file" <c:if test="${not empty model.avatar}">value="${model.avatar}"</c:if>/>
											<div class="" id="fileUpload" style="border: 2px dashed #e1d8ee; border-radius: 24px; margin-top: 5px; min-height: 128px;"> 
												<div class="dz-default dz-message">
													<%-- <c:if test="${empty model.avatar}"><span>image of user</span></c:if> --%>
													<img id="changeImg" alt="" src="<c:if test="${not empty model.avatar}">${pageContext.request.contextPath}/template/upload/${model.avatar}</c:if>" style="border-radius: 25px;">
												</div>
											</div>
										</div>
                                </div>

                                <div class="form-row mt-1">
                                    <div class="form-group col-6 m-0">
                                        <label class="col-form-label s-12"><i class="icon-envelope-o mr-2"></i>Email</label>
                                        <form:input path="email" onfocusout="" placeholder="user@email.com" cssClass="form-control r-0 light s-12 " type="email" required="required"/>
                                        <span class="error" aria-live="polite"></span>
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
											<form:option value="" label="Choose..."/>
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
	var form = document.getElementById("formSubmit");
	
	(function () {
		"use strict";
		window.addEventListener("load", function () {
			var btnPublish = document.getElementById("btnAddOrUpdateUser");
			var data = {};

			var fileInput = document.getElementById('uploadImage');
			$('#uploadImage').change(function() {
				var files = fileInput.files[0];
				if (files) {
					var reader = new FileReader();
					reader.onload = function(e) {
						data[""+"imagePath"+""] = e.target.result;
						data[""+"avatar"+""] = files.name;
					};
					reader.readAsDataURL(files);
				}
				
				$("#changeImg").attr("src", "${pageContext.request.contextPath}/template/upload/" + files.name);
			});

			btnPublish.addEventListener("click", function (event) {
				event.preventDefault(); // Huỷ bỏ event nếu nó có thể huỷ mà không dừng sự lan rộng (propagation) của event tới phần khác.

				form.classList.add("was-validated");
				
				if (email.validity.valid) {
					if (form.checkValidity() == true) { // Returns true if an input element contains valid data.
						event.stopPropagation(); // Ngăn chặn sự lan rộng của sự kiện hiện tại tới thằng khác.
						var editorElement = document.getElementById("email");

						// TODO: fix validation
						// THÊM / SỬA
						event.preventDefault();
						
						var formData = $('#formSubmit').serializeArray();
						$.each(formData, function (i, v) {
							data[""+v.name+""] = v.value;
						});
						var id = $('#emplID').val();
						
						/* var formData = new FormData();
			            var Data = $('#formSubmit').serializeArray();
			            $.each(Data, function (i, v) {
			                formData.append(""+v.name+"", v.value);
			            });
						var fileInput = document.getElementById('image');
			            var file = fileInput.files[0];
			            formData.append('image', file);

			            var id = $('#emplID').val(); */
						
						if (id == "") {
							addUser(data);
						} else {
							updateUser(data);
						}
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
						window.location.href = "${editUserURL}?message=create_failed";
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

	function checkUserEmail() {
		var email = $("#email").val();
		if (email != '') {
			const emailInput = document.getElementById('email');
			const emailError = document.querySelector('#email + span.error');
			$.ajax({
				url: '${userAPI}/checkemail',
				type: 'POST',
				contentType: 'text/plain',
				data: email,
				dataType: 'json',
				success: function (result) {
					//var emailInput = document.getElementById("email");
					if (result) {
						console.log("ton tai")
						emailInput.classList.add("my-error");
						//emailInput.classList.remove("is-valid");
						emailError.textContent = 'Đã tồn tại email này!';
					} else {
						console.log("chua ton tai")
						emailInput.classList.remove("my-error");
						//emailInput.classList.add("is-valid");
						emailError.textContent = ''; // Reset the content of the message
						emailError.className = 'error'; // Reset the visual state of the message
					}
				}
			});
		}
	}
</script>

</body>
</html>