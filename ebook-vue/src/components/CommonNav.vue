<template>
  <nav class="navbar navbar-default navbar-static-top m-b-0">
    <div class="navbar-header">
      <div class="top-left-part">
        <!-- Logo -->
        <router-link to="/">
          <a class="logo">
            <img src="../assets/plugins/images/logo.jpg" width="50%" height="50%">
          </a>
        </router-link>
      </div>
      <!-- /Logo -->
      <!-- Toggle icon -->

      <ul class="nav navbar-top-links navbar-right pull-right">
        <li class="dropdown">
          <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="javascript:void(0)">
            <img src="../assets/plugins/images/users/user.jpg" alt="user-img" width="36" class="img-circle">
            <b class="hidden-xs">Bert Zhang</b><span class="caret"></span> </a>
          <ul class="dropdown-menu dropdown-user animated flipInY">
            <li>
              <div class="dw-user-box">
                <div class="u-text">
                  <h4>Bert Zhang</h4>
                </div>
              </div>
            </li>
            <li role="separator" class="divider"></li>
            <li><a href="javascript:void(0)">My Profile</a></li>
            <li><a href="javascript:void(0)">My Balance</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="javascript:void(0)">Account Setting</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="javascript:void(0)">Logout</a></li>
          </ul>
          <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
      </ul>
    </div>
    <!-- /.navbar-header -->
    <!-- /.navbar-top-links -->
    <!-- /.navbar-static-side -->
  </nav>
</template>

<script>
  export default {
    name: 'CommonNav'
  }
</script>

<style>

</style>
