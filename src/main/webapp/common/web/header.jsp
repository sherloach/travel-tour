<%@ page import="com.nqhtour.util.SecurityUtils" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="header">
      <nav class="nav nav--tours">
        <a href="<c:url value='/trang-chu'/>" class="nav__el">All tours</a>
        <form class="nav__search">
          <button class="nav__search-btn">
            <svg>
              <use xlink:href="/template/web/img/icons.svg##icon-search"></use>
            </svg>
          </button>
          <input
            type="text"
            placeholder="Search tours"
            class="nav__search-input"
            id="my_search_input"
            onkeypress="keyPressSearch(event)"
          />
        </form>
      </nav>
      <div class="header__logo">
        <img src="/template/web/img/logo-white.png" alt="Natours logo" />
      </div>
      <nav class="nav nav--user">
<!--         <a href="#" class="nav__el">My bookings</a>
        <a href="#" class="nav__el">
          <img src="img/user.jpg" alt="User photo" class="nav__user-img" />
          <span>NQH</span>
        </a>
 -->
		<security:authorize access = "isAnonymous()">
			<a href="<c:url value='/login'/>" class="nav__el">Log in</a>
			<a href="<c:url value='/signup'/>" class="nav__el nav__el--cta">Sign up</a>
        </security:authorize>
        <security:authorize access = "isAuthenticated()">
			<a href="<c:url value='#'/>" class="nav__el">Welcome <%=SecurityUtils.getPrincipal().getFullName()%></a>
			<a href="<c:url value='/logout'/>" class="nav__el nav__el--cta">Log out</a>
        </security:authorize>
      </nav>
</header>