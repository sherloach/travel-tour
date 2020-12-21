<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="clientAPI" value="/api/client"/>
<c:url var="clientURL" value="/web/client/add"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo" style="background: #27ae60 ">
        <div class="wrapper wrapper--w680">
            <div class="card card-1">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Registration Info</h2>
                    <form id="register-form" method="post" role="form" autocomplete="on">
                        <div class="input-group">
                            <input class="input--style-1" type="text" placeholder="NAME" id="name" name="name">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1" type="text" placeholder="EMAIL" id="email" name="email">
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1" type="password" placeholder="PASSWORD" id="password" name="password" required="required">
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-1" type="text" placeholder="PHONE" id="phoneNumber" name="phoneNumber">
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="gender">
                                            <option disabled="disabled" selected="selected">GENDER</option>
                                            <option value="true">Male</option>
                                            <option value="false">Female</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="input-group">
							<input class="input--style-1" type="text" placeholder="ADDRESS" id="address" name="address">
                        </div>
                        <div class="p-t-20">
                            <button id="btnRegister" class="btn btn--radius btn--green" type="button">Submit</button>
                        </div>
                    </form>
					<c:if test="${not empty message}">
						<div role="alert" class="alert alert-${alert}">
							  <strong>${message}</strong>
						</div>
					</c:if>
                </div>
            </div>
        </div>
    </div>

	<script>
		$(function() {
			$.validator.addMethod("hoTenPattern", function (value, element) {
				return this.optional(element) || /^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵýỷỹ\s]+$/.test(value);
			}, "Hãy nhập họ tên ít nhất 8 ký tự chỉ gồm chữ cái!");

			$.validator.addMethod("soDienThoaiPattern", function (value, element) {
				return this.optional(element) || /(09|03|07|01)+([0-9]{8})\b/.test(value);
			}, "Số điện thoại không hợp lệ!");

			$("#register-form").validate({
				rules: {
					name: {
						required: true,
						hoTenPattern: true
					},
					address: {
						required: true,
						minlength: 5
					},
					phoneNumber: {
						required: true,
						soDienThoaiPattern: true
					},
					email: {
						required: true,
						email: true
					},
					password: {
						required: true,
						minlength: 6
					},
				},

				messages: {
					name: {
						required: "Vui lòng nhập họ tên!"
					},
					password: {
						required: "Vui lòng nhập mật khẩu",
						minlength: "Mật khẩu phải bao gồm ít nhất 6 ký tự!"
					},
					address: {
						required: "Vui lòng nhập địa chỉ!",
						minlength: "Địa chỉ phải bao gồm ít nhất 5 kí tự!"
					},
					email: {
						required: "Vui lòng nhập địa chỉ email!",
						email: "Email không hợp lệ",
						uniqueEmail: "That email is already taken."
					},
					phoneNumber: {
						required: "Vui lòng nhập số điện thoại!"
					}
				}
			});

			$('#btnRegister').click(function (e) {
				var check = $('#register-form').valid();
				if (check) {
					e.preventDefault();
					var data = {};
					var formData = $('#register-form').serializeArray();
					$.each(formData, function (i, v) {
						/* if (i == 3) {
							if (v.value == "1") {
								v.value = 1;
							} else {
								v.value = 0;
							}
						} */
						data[""+v.name+""] = v.value;
					});
					addClient(data);
				}
	        });

			function addClient(data) {
				$.ajax({
					url: '${clientAPI}',
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function (result) {
						window.location.href = "signup?message=create_success";
					},
					error: function (error) {
						console.log(error);
						window.location.href = "signup?message=create_failed";
					}
				});
			}
		});
		
	</script>
</body>
</html>