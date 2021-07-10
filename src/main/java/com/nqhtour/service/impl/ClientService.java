package com.nqhtour.service.impl;

import com.nqhtour.converter.ClientTourConverter;
import com.nqhtour.converter.TourConverter;
import com.nqhtour.dto.ClientTourDTO;
import com.nqhtour.dto.TourDTO;
import com.nqhtour.entity.ClientTourEntity;
import com.nqhtour.repository.ClientTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nqhtour.constant.SystemConstant;
import com.nqhtour.converter.ClientConverter;
import com.nqhtour.converter.UserConverter;
import com.nqhtour.dto.ClientDTO;
import com.nqhtour.dto.UserDTO;
import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.TourEntity;
import com.nqhtour.entity.UserEntity;
import com.nqhtour.repository.ClientRepository;
import com.nqhtour.repository.TourRepository;
import com.nqhtour.repository.UserRepository;
import com.nqhtour.service.IClientService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements IClientService {
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ClientConverter clientConverter;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TourRepository tourRepository;

	@Autowired
	ClientTourRepository clientTourRepository;

	@Autowired
	UserConverter userConverter;

	@Autowired
	private ClientTourConverter clientTourConverter;

	@Autowired
	PasswordEncoder passwordEncode;

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public ClientDTO save(ClientDTO dto) {
		ClientEntity entity = new ClientEntity();
		UserEntity userEntity = null;

		if (dto.getId() != null) {
			//UserEntity oldUser = userRepository.findOne(dto.getUserID());
			ClientEntity oldClient = clientRepository.findOne(dto.getId());
			userEntity = userRepository.findOne(dto.getUserID());

			//UserEntity userUpdate = userConverter.toEntity(oldUser, userDTO);
			//userEntity = userRepository.save(userUpdate);
			entity = clientConverter.toEntity(oldClient, dto);
		} else {
			// Set user data
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(dto.getEmail());
			userDTO.setPassword(passwordEncode.encode(dto.getPassword()));
			userDTO.setRole("CLIENT");
			userDTO.setStatus(1);


			// Check email user exist or not?
			userEntity = userRepository.findOneByUserNameAndStatus(userDTO.getUsername(), SystemConstant.ACTIVE_STATUS);
			if (userEntity != null) {
				throw new ArrayIndexOutOfBoundsException();
			}
			userEntity = userRepository.save(userConverter.toEntity(userDTO));

			//dto.setUserID(userID);
			entity = clientConverter.toEntity(dto);
		}

		entity.setUser(userEntity);
		return clientConverter.toDTO(clientRepository.save(entity));
	}

	public boolean booking(Long idClient, TourEntity tourEntity, int nuTickets) throws MessagingException {
		// Update current tickets available
		int currentGroupSize = tourEntity.getCurrentGroupSize() + nuTickets;
		tourEntity.setCurrentGroupSize(currentGroupSize);
		tourRepository.save(tourEntity);

		ClientTourEntity clientTourEntity = new ClientTourEntity();
		ClientEntity clientEntity = clientRepository.findOne(idClient);
		clientTourEntity.setClientEntity(clientEntity);
		clientTourEntity.setTourEntity(tourEntity);
		clientTourEntity.setNuTickets(nuTickets);
		clientTourRepository.save(clientTourEntity);
		//sendEmail(clientEntity.getEmail(), nuTickets, tourEntity);
		return true;
	}

	@Override
	public String sendEmail(String email, int nuTickets, TourEntity tourEntity) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();

		boolean multipart = true;

		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
		String total = String.valueOf(tourEntity.getPrice() * nuTickets);

		String htmlMsg = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
				"<head>\n" +
				"<!--[if gte mso 9]>\n" +
				"<xml>\n" +
				"  <o:OfficeDocumentSettings>\n" +
				"    <o:AllowPNG/>\n" +
				"    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
				"  </o:OfficeDocumentSettings>\n" +
				"</xml>\n" +
				"<![endif]-->\n" +
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
				"  <meta name=\"x-apple-disable-message-reformatting\">\n" +
				"  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
				"  <title></title>\n" +
				"  \n" +
				"    <style type=\"text/css\">\n" +
				"      a { color: #6d6d6d; text-decoration: none; } @media (max-width: 480px) { #u_content_image_1 .v-src-width { width: auto !important; } #u_content_image_1 .v-src-max-width { max-width: 50% !important; } #u_content_text_1 .v-text-align { text-align: center !important; } }\n" +
				"@media only screen and (min-width: 620px) {\n" +
				"  .u-row {\n" +
				"    width: 600px !important;\n" +
				"  }\n" +
				"  .u-row .u-col {\n" +
				"    vertical-align: top;\n" +
				"  }\n" +
				"\n" +
				"  .u-row .u-col-33p33 {\n" +
				"    width: 199.98px !important;\n" +
				"  }\n" +
				"\n" +
				"  .u-row .u-col-50 {\n" +
				"    width: 300px !important;\n" +
				"  }\n" +
				"\n" +
				"  .u-row .u-col-66p67 {\n" +
				"    width: 400.02px !important;\n" +
				"  }\n" +
				"\n" +
				"  .u-row .u-col-100 {\n" +
				"    width: 600px !important;\n" +
				"  }\n" +
				"\n" +
				"}\n" +
				"\n" +
				"@media (max-width: 620px) {\n" +
				"  .u-row-container {\n" +
				"    max-width: 100% !important;\n" +
				"    padding-left: 0px !important;\n" +
				"    padding-right: 0px !important;\n" +
				"  }\n" +
				"  .u-row .u-col {\n" +
				"    min-width: 320px !important;\n" +
				"    max-width: 100% !important;\n" +
				"    display: block !important;\n" +
				"  }\n" +
				"  .u-row {\n" +
				"    width: calc(100% - 40px) !important;\n" +
				"  }\n" +
				"  .u-col {\n" +
				"    width: 100% !important;\n" +
				"  }\n" +
				"  .u-col > div {\n" +
				"    margin: 0 auto;\n" +
				"  }\n" +
				"  .no-stack .u-col {\n" +
				"    min-width: 0 !important;\n" +
				"    display: table-cell !important;\n" +
				"  }\n" +
				"\n" +
				".no-stack .u-col-50 {\n" +
				"    width: 50% !important;\n" +
				"  }\n" +
				"\n" +
				"}\n" +
				"body {\n" +
				"  margin: 0;\n" +
				"  padding: 0;\n" +
				"}\n" +
				"\n" +
				"table,\n" +
				"tr,\n" +
				"td {\n" +
				"  vertical-align: top;\n" +
				"  border-collapse: collapse;\n" +
				"}\n" +
				"\n" +
				"p {\n" +
				"  margin: 0;\n" +
				"}\n" +
				"\n" +
				".ie-container table,\n" +
				".mso-container table {\n" +
				"  table-layout: fixed;\n" +
				"}\n" +
				"\n" +
				"* {\n" +
				"  line-height: inherit;\n" +
				"}\n" +
				"\n" +
				"a[x-apple-data-detectors='true'] {\n" +
				"  color: inherit !important;\n" +
				"  text-decoration: none !important;\n" +
				"}\n" +
				"\n" +
				"@media (max-width: 480px) {\n" +
				"  .hide-mobile {\n" +
				"    display: none !important;\n" +
				"    max-height: 0px;\n" +
				"    overflow: hidden;\n" +
				"  }\n" +
				"\n" +
				"}\n" +
				"    </style>\n" +
				"  \n" +
				"  \n" +
				"\n" +
				"<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
				"\n" +
				"</head>\n" +
				"\n" +
				"<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #eeeeee\">\n" +
				"  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
				"  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
				"  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #eeeeee;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
				"  <tbody>\n" +
				"  <tr style=\"vertical-align: top\">\n" +
				"    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
				"    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #eeeeee;\"><![endif]-->\n" +
				"    \n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #2dc26b;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #2dc26b;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"200\" style=\"width: 200px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table id=\"u_content_image_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:31px 10px 25px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
				"  <tr>\n" +
				"    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
				"      \n" +
				"      <img align=\"center\" border=\"0\" src=\"https://bookingtour.herokuapp.com/template/web/img/logo-white.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 33%;max-width: 59.4px;\" width=\"59.4\" class=\"v-src-width v-src-max-width\"/>\n" +
				"      \n" +
				"    </td>\n" +
				"  </tr>\n" +
				"</table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"400\" style=\"width: 400px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-66p67\" style=\"max-width: 320px;min-width: 400px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table class=\"hide-mobile\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #ecf0f1;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"<table id=\"u_content_text_1\" style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:13px 26px 16px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 140%; text-align: right; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px;\"><strong><span style=\"line-height: 25.2px; font-size: 18px;\">NQH TOUR</span></strong></span></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
				"  <tr>\n" +
				"    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
				"      \n" +
				"      <img align=\"center\" border=\"0\" src=\"https://www.freeiconspng.com/thumbs/success-icon/success-icon-10.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 17%;max-width: 98.6px;\" width=\"98.6\" class=\"v-src-width v-src-max-width\"/>\n" +
				"      \n" +
				"    </td>\n" +
				"  </tr>\n" +
				"</table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #47484b; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 30px; line-height: 42px;\">Thanks for your payment!</span></strong></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:2px 40px 25px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #2dc26b; line-height: 170%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 170%; text-align: center;\"><strong>Your booking has been confirmed</strong></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:2px 40px 25px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #34495e; line-height: 170%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 170%;\">Hi " + email + ", </p>\n" +
				"<p style=\"font-size: 14px; line-height: 170%;\">Your tour was confirmed by NQHTour. Please find the details below:</p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row no-stack\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #615e5e; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\">" + tourEntity.getName() +"</p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #615e5e; line-height: 140%; text-align: right; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 14px; line-height: 19.6px;\">" + tourEntity.getPrice() + " VND</span></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row no-stack\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #615e5e; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\">Tickets</p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #615e5e; line-height: 140%; text-align: right; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 14px; line-height: 19.6px;\">x" + nuTickets + "</span></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row no-stack\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #615e5e; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 14px; line-height: 19.6px;\">Total</span></strong></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #615e5e; line-height: 140%; text-align: right; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 14px; line-height: 19.6px;\">" + total + " VND</span></strong></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:14px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #ffffff;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
				"  <tr>\n" +
				"    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
				"      \n" +
				"      <img align=\"center\" border=\"0\" src=\"http://localhost:8080/template/upload/tour/" + tourEntity.getImageCover() + "\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 280px;\" width=\"280\" class=\"v-src-width v-src-max-width\"/>\n" +
				"      \n" +
				"    </td>\n" +
				"  </tr>\n" +
				"</table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"width: 300px;padding: 0px 30px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px 30px 30px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #5c5757; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p dir=\"ltr\" style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\n" +
				"<p dir=\"ltr\" style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\n" +
				"<p dir=\"ltr\" style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\n" +
				"<p dir=\"ltr\" style=\"font-size: 14px; line-height: 140%;\"><strong><span style=\"font-size: 14px; line-height: 19.6px;\">Details:</span></strong></p>\n" +
				"<p style=\"font-size: 14px; line-height: 140%;\">" + tourEntity.getLocation() + "</p>\n" +
				"<p style=\"font-size: 14px; line-height: 140%;\">" + tourEntity.getStartDate() + "</p>\n" +
				"<p style=\"font-size: 14px; line-height: 140%;\">" + tourEntity.getDuration() + " days</p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #0095df;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #0095df;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"    <tbody>\n" +
				"      <tr style=\"vertical-align: top\">\n" +
				"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
				"          <span>&#160;</span>\n" +
				"        </td>\n" +
				"      </tr>\n" +
				"    </tbody>\n" +
				"  </table>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:2px 40px 15px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #e03e2d; line-height: 170%; text-align: left; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 170%; text-align: center;\"><strong><em><span style=\"font-size: 14px; line-height: 23.8px;\">This booking is non-refundable. Changing the dates of your stay is not possible.</span></em></strong></p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"\n" +
				"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
				"  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #236fa1;\">\n" +
				"    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
				"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #236fa1;\"><![endif]-->\n" +
				"      \n" +
				"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #2dc26b;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
				"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
				"  <div style=\"background-color: #2dc26b;width: 100% !important;\">\n" +
				"  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
				"  \n" +
				"<table style=\"font-family:'Open Sans',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
				"  <tbody>\n" +
				"    <tr>\n" +
				"      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:16px;font-family:'Open Sans',sans-serif;\" align=\"left\">\n" +
				"        \n" +
				"  <div class=\"v-text-align\" style=\"color: #ecf7ff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
				"    <p style=\"font-size: 14px; line-height: 140%;\">&copy; NQH Tour. All Rights Reserved</p>\n" +
				"  </div>\n" +
				"\n" +
				"      </td>\n" +
				"    </tr>\n" +
				"  </tbody>\n" +
				"</table>\n" +
				"\n" +
				"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
				"  </div>\n" +
				"</div>\n" +
				"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
				"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
				"    </div>\n" +
				"  </div>\n" +
				"</div>\n" +
				"\n" +
				"\n" +
				"    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
				"    </td>\n" +
				"  </tr>\n" +
				"  </tbody>\n" +
				"  </table>\n" +
				"  <!--[if mso]></div><![endif]-->\n" +
				"  <!--[if IE]></div><![endif]-->\n" +
				"</body>\n" +
				"\n" +
				"</html>\n";

		message.setContent(htmlMsg, "text/html");

		helper.setTo(email);
		helper.setSubject("Tour Confirmation Email");

		this.emailSender.send(message);

		return "Email Sent!";
	}


	@Override
	public ClientDTO findById(long id) {
		ClientEntity entity = clientRepository.findOne(id);
		return clientConverter.toDTO(entity);
	}

	@Override
	public ClientDTO findByEmail(String email) {
		ClientEntity entity = clientRepository.findOneByEmail(email);
		return clientConverter.toDTO(entity);
	}

	@Override
	public List<ClientTourDTO> myTour(String email) {
		List<ClientTourDTO> models = new ArrayList<>();
		ClientEntity client = clientRepository.findOneByEmail(email);
		List<ClientTourEntity> entity = clientTourRepository.findAllByClientEntity(client);
		for (ClientTourEntity item : entity) {
			ClientTourDTO clientTourDTO = clientTourConverter.toDTO(item);
			models.add(clientTourDTO);
		}
		return models;
	}

	@Override
	public boolean checkBookingExist(Long idClient, Long idTour) {
		ClientEntity client = clientRepository.findOne(idClient);
		TourEntity tour = tourRepository.findOne(idTour);
		ClientTourEntity entity = clientTourRepository.findOneByClientEntityAndTourEntity(client, tour);
		if (entity == null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteTourBooking(ClientEntity client, Long idTour) {
		TourEntity tour = tourRepository.findOne(idTour);
		ClientTourEntity entity = clientTourRepository.findOneByClientEntityAndTourEntity(client, tour);
		tour.setCurrentGroupSize(tour.getCurrentGroupSize() - entity.getNuTickets());
		tourRepository.save(tour);
		clientTourRepository.delete(entity);
	}

}
