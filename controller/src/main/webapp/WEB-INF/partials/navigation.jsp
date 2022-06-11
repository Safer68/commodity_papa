<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="g-navigation">
    <header class="g-header">
        <a class="g-header__title d-flex align-items-center justify-content-center"
           href="index.html">
            <i class="far fa-clone"></i>
            <span class="g-header__site-name">
      &nbsp;G<span class="e-site-emphasize">Admin</span>
    </span>
        </a>

        <div class="d-flex justify-content-between">
            <div class="d-flex align-items-center">
                <a class="g-header__sidebar-toggle"
                   href="javascript:void(0)">
                    <i class="fas fa-bars"></i>
                </a>
            </div>

            <ul class="nav d-flex align-items-center">
                <li class="g-header__nav-item dropdown">
                    <a class="g-header__nav-link nav-link dropdown-toggle d-flex active align-items-center"
                       href="#">
                        <img class="g-header__profile-photo rounded-circle"
                             src="https://avatars3.githubusercontent.com/u/1621344?s=460&v=4">
                        Christian
                    </a>
                </li>
                <li class="g-header__nav-item dropdown">
                    <a class="g-header__nav-link nav-link dropdown-toggle d-flex active align-items-center"
                       data-toggle="dropdown"
                       role="button"
                       aria-haspopup="true"
                       aria-expanded="false">
                        <i class="g-header__icon far fa-envelope">
                            <span class="g-header__alert badge-success badge-pill">6</span>
                        </i>
                    </a>
                    <div class="g-notification g-notification--messages dropdown-menu dropdown-menu-right">
                        <div class="g-notification__items">
                            <a class="g-notification__item dropdown-item" href="#">
                                <div>
                                    <img class="g-notification__image rounded-circle float-left"
                                         src="https://randomuser.me/api/portraits/men/27.jpg">
                                    <span class="g-notification__title">John Doe</span>
                                    <span class="g-notification__message">Hey there!</span>
                                    <span class="g-notification__time">10 mins ago</span>
                                </div>
                            </a>
                            <a class="g-notification__item dropdown-item" href="#">
                                <div>
                                    <img class="g-notification__image rounded-circle float-left"
                                         src="https://randomuser.me/api/portraits/women/68.jpg">
                                    <span class="g-notification__title">Jane Doe</span>
                                    <span class="g-notification__message">Thanks for using this theme!</span>
                                    <span class="g-notification__time">1 hour ago</span>
                                </div>
                            </a>
                            <a class="g-notification__item dropdown-item" href="#">
                                <div>
                                    <img class="g-notification__image rounded-circle float-left"
                                         src="https://randomuser.me/api/portraits/men/60.jpg">
                                    <span class="g-notification__title">Richard Roe</span>
                                    <span class="g-notification__message">Cheers!</span>
                                    <span class="g-notification__time">1 day ago</span>
                                </div>
                            </a>
                            <a class="g-notification__item dropdown-item" href="#">
                                <div>
                                    <img class="g-notification__image rounded-circle float-left"
                                         src="https://randomuser.me/api/portraits/men/27.jpg">
                                    <span class="g-notification__title">John Doe</span>
                                    <span class="g-notification__message">Hey there!</span>
                                    <span class="g-notification__time">15 days ago</span>
                                </div>
                            </a>
                            <a class="g-notification__item dropdown-item" href="#">
                                <div>
                                    <img class="g-notification__image rounded-circle float-left"
                                         src="https://randomuser.me/api/portraits/women/68.jpg">
                                    <span class="g-notification__title">Jane Doe</span>
                                    <span class="g-notification__message">Thanks for using this theme!</span>
                                    <span class="g-notification__time">1 month ago</span>
                                </div>
                            </a>
                            <a class="g-notification__item dropdown-item" href="#">
                                <div>
                                    <img class="g-notification__image rounded-circle float-left"
                                         src="https://randomuser.me/api/portraits/men/60.jpg">
                                    <span class="g-notification__title">Richard Roe</span>
                                    <span class="g-notification__message">Cheers!</span>
                                    <span class="g-notification__time">1 year ago</span>
                                </div>
                            </a>
                        </div>
                        <a class="g-notification__item g-notification__item--toolbar dropdown-item text-center"
                           href="#">
                            Show older messages
                        </a>
                    </div>
                </li>

                <li class="g-header__nav-item dropdown">
                    <a class="g-header__nav-link nav-link dropdown-toggle d-flex active align-items-center"
                       data-toggle="dropdown"
                       role="button"
                       aria-haspopup="true"
                       aria-expanded="false">
                        <i class="g-header__icon g-header__icon--caret fas fa-caret-down"></i>
                    </a>
                    <div class="g-notification dropdown-menu dropdown-menu-right">
                        <a class="g-notification__item dropdown-item" href="#">Help</a>
                        <a class="g-notification__item dropdown-item" href="#">Activity Log</a>
                        <a class="g-notification__item dropdown-item" href="#">Preferences</a>
                        <a class="g-notification__item dropdown-item" href="#">
                            Settings
                            <span class="badge badge-pill badge-danger float-right">50%</span>
                        </a>
                        <div class="g-notification__divider dropdown-divider"></div>
                        <a class="g-notification__item dropdown-item" href="#">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </header>
    <%--<c:import url="header.jsp"/>--%>
    <%--<c:import url="sidebar.jsp"/>--%>
    <%--@@include('./header/header.html')
    @@include('./sidebar/sidebar.html')--%>
    <nav class="g-sidebar">
        <div class="g-sidebar__profile container d-flex active align-items-center">
            <img class="g-sidebar__profile-photo rounded-circle img-fluid"
                 src="https://avatars3.githubusercontent.com/u/1621344?s=460&v=4"/>

            <div class="g-sidebar__details">
                <span class="g-sidebar__profile-message">Welcome,</span>
                <span class="g-sidebar__profile-name">Christian Esperar</span>
            </div>
        </div>

        <div class="g-sidebar__menu">
            <ul class="g-sidebar__menu-list">
                <li class="g-sidebar__menu-item">
                    <a class="g-sidebar__menu-link" href="index.html">
                        <i class="g-sidebar__menu-icon fas fa-home"></i>
                        <span class="g-sidebar__menu-description">Dashboard</span>
                    </a>
                </li>

                <li class="g-sidebar__menu-item">
                    <a class="g-sidebar__menu-link" href="bootstrap-4-components.html">
                        <i class="g-sidebar__menu-icon fas e-bootstrap-logo-b">
                            B <span class="e-bootstrap-logo-4">4</span>
                        </i>
                        <span class="g-sidebar__menu-description">Components</span>
                    </a>
                </li>
            </ul>

            <span class="g-sidebar__menu-title">Examples</span>

            <ul class="g-sidebar__menu-list">
                <li class="g-sidebar__menu-item">
                    <a class="g-sidebar__menu-link">
                        <i class="g-sidebar__menu-icon far fa-window-restore"></i>
                        <span class="g-sidebar__menu-description">Layout</span>
                    </a>
                    <ul class="g-sidebar__menu-list">
                        <li class="g-sidebar__menu-item">
                            <a class="g-sidebar__menu-link" href="layout-fixed-navigation.html">
                                Fixed navigation
                            </a>
                        </li>
                        <li class="g-sidebar__menu-item">
                            <a class="g-sidebar__menu-link" href="layout-fixed-footer.html">
                                Fixed footer
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="g-sidebar__menu-item">
                    <a class="g-sidebar__menu-link">
                        <i class="g-sidebar__menu-icon fas fa-file"></i>
                        <span class="g-sidebar__menu-description">Pages</span>
                    </a>
                    <ul class="g-sidebar__menu-list">
                        <li class="g-sidebar__menu-item">
                            <a class="g-sidebar__menu-link" href="pages-blank.html">
                                Blank
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="g-sidebar__menu-item">
                    <a class="g-sidebar__menu-link">
                        <!-- <i class="g-sidebar__menu-icon fas fa-sitemap"></i> -->
                        <!-- <i class="g-sidebar__menu-icon fas fa-bars"></i> -->
                        <i class="g-sidebar__menu-icon fas fa-list-ul"></i>
                        <span class="g-sidebar__menu-description">Multilevel Menu</span>
                    </a>

                    <!-- First Level Menu -->
                    <ul class="g-sidebar__menu-list">
                        <li class="g-sidebar__menu-item">
                            <a class="g-sidebar__menu-link" href="javascript:void(0)">
                                Level One
                            </a>
                        </li>
                        <li class="g-sidebar__menu-item">
                            <a class="g-sidebar__menu-link" href="javascript:void(0)">
                                Level One
                            </a>

                            <!-- Second Level Menu -->
                            <ul class="g-sidebar__menu-list">
                                <li class="g-sidebar__menu-item">
                                    <a class="g-sidebar__menu-link" href="javascript:void(0)">
                                        Level Two
                                    </a>
                                </li>
                                <li class="g-sidebar__menu-item">
                                    <a class="g-sidebar__menu-link" href="javascript:void(0)">
                                        Level Two
                                    </a>
                                </li>
                                <li class="g-sidebar__menu-item">
                                    <a class="g-sidebar__menu-link" href="javascript:void(0)">
                                        Level Two
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="g-sidebar__menu-item">
                            <a class="g-sidebar__menu-link" href="javascript:void(0)">
                                Level One
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

        <ul class="g-sidebar__footer">
            <li class="g-sidebar__footer-list">
                <a class="g-sidebar__footer-link" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Settings">
                    <i class="fas fa-cog"></i>
                </a>
            </li>
            <li class="g-sidebar__footer-list">
                <a class="g-sidebar__footer-link" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Fullscreen">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="g-sidebar__footer-list">
                <a class="g-sidebar__footer-link" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Lock">
                    <i class="far fa-eye-slash"></i>
                </a>
            </li>
            <li class="g-sidebar__footer-list">
                <a class="g-sidebar__footer-link" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Logout">
                    <i class="fas fa-power-off"></i>
                </a>
            </li>

        </ul>
    </nav>
</div>
