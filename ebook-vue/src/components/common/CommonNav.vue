<template>
  <Menu mode="horizontal" theme="light" style="width: 100%">
    <Row style="height: 100%">
      <Col span="6" style="height: 100%">
        <div class="layout-logo">
          <a class="logo" href="#">
            <img src="../../assets/images/logo.jpg" width="50%" height="100%">
          </a>
        </div>
        <Divider type="vertical" style="height: 98%"/>
      </Col>
      <Col span="3" offset="15" style="height: 100%">
        <div class="layout-nav">
          <Submenu name="3">
            <template slot="title">
              <img style="margin-right: 5px" src="../../assets/images/users/user.jpg" alt="user-img" width="36" class="rounded-circle">
              <span> <b class="hidden-xs">Bert Zhang</b></span>
            </template>

            <MenuItem  name="3-1">My Profile</MenuItem>
            <MenuItem  name="3-2">My Balance</MenuItem>
            <Divider style="margin: 0"/>
            <MenuItem  name="3-3">Account Setting</MenuItem>
            <Divider style="margin: 0"/>
            <MenuItem  name="3-4">Logout</MenuItem>
          </Submenu>
        </div>
      </Col>
    </Row>
  </Menu>
</template>

<script>
  export default {
    name: "CommonNav",
  }
</script>

<style scoped>
  .layout-logo {
    width: 220px;
    height: 100%;
    border-radius: 3px;
    float: left;
    position: relative;
    left: 20px;
  }

</style>
