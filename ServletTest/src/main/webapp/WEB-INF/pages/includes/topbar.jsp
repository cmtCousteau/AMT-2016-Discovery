<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<input type="checkbox" id="zm-switchzetta-menu1"/>
<ul onclick="">
    <li class=" zm-img">
        <a href="#">
            <img title="zettaMenu logo image" src="upload/logo.png">
        </a>
    </li>
    <li class=" zm-active"><a href="index.jsp">Home</a>
    </li>
    <li class=" zm"><a href="usersManager">User manager</a>
    </li>
    <c:if test="${sessionScope.user.userName != null}">
        <li class=" zm-right-item><a href="#">My Account</a>
        </li>
    </c:if>
    <c:if test="${sessionScope.user.userName == null}">
        <li class=" zm-right-item"><a href="Login">login</a>
        </li>
        <li class=" zm-right-item"><a href="CreateAccount">Create Account</a>
        </li>
    </c:if>


    <li class=" zm-right-item zm-search"><a><i class="zm-icon fa fa-search"></i></a>
        <div>
            <form action="">
                <input type="text" class="zm-search-place" name="search" placeholder="Search">
                <button type="submit" class="zm-search-button"><i class="zm-icon fa fa-search"></i>
                </button>
            </form>
        </div>
    </li>
    <li class="zm-switch">
        <a>
            <label for="zm-switchzetta-menu1"><i class="fa fa-bars"></i>
            </label>
        </a>
    </li>
</ul>