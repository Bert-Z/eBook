<template>
  <div class="common_nav">
    <Menu mode="horizontal" theme="light" style="height: 100%; width: 100%">
      <Row style="height: 100%">
        <Col span="6" style="height: 100%">
          <div class="layout-logo">
            <router-link class="logo" :to="{name:'Index'}">
              <img src="../../assets/images/logo.jpg" width="50%" height="100%">
            </router-link>
          </div>
          <Divider type="vertical" style="height: 60px" />
        </Col>
        <Col v-if="user" span="3" offset="15" style="height: 100%">
          <div class="layout-nav">
            <Submenu name="3">
              <template slot="title">
                <img style="margin-right: 5px" src="../../assets/images/users/user.jpg" alt="user-img" width="36" class="rounded-circle">
                <span> <b class="hidden-xs">{{name}}</b></span>
              </template>
              <MenuItem v-if="admin==='1'"  name="3-1" disabled>Manager</MenuItem>
              <MenuItem v-if="admin==='0'" name="3-1" disabled>User</MenuItem>
              <Divider style="margin: 0"/>
              <MenuItem  name="3-1" :to="{name:'ShoppingCart'}">My Shopping Cart</MenuItem>
              <MenuItem  name="3-2" :to="{name:'AllOrders'}">My Orders</MenuItem>
              <Divider style="margin: 0"/>
              <MenuItem  name="3-3">Account Setting</MenuItem>
              <Divider style="margin: 0"/>
              <MenuItem  name="3-4"><a @click="quit">Logout</a></MenuItem>
            </Submenu>
          </div>
        </Col>
      </Row>
    </Menu>
  </div>
</template>

<script>
  import {setCookie,getCookie,delCookie} from "../../util/util";

  export default {
    name: "CommonNav",
    props:["user"],
    data(){
      return {
        name:"",
        admin:0,
      }
    },
    mounted(){
      if(this.user){
        let username=getCookie('name');
        let admin=getCookie('admin');
        this.name=username;
        this.admin=admin;
        // console.log(username);
        if(username === ""){
          this.$router.push({name:"SignIn"});
        }
      }
    },
    methods:{
      quit:function () {
        delCookie('name');
        delCookie('admin');
        this.$router.go(0);
      }
    }
  }
</script>

<style>

</style>

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
