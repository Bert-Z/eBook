<template>
  <div class="common_nav">
    <Menu mode="horizontal" theme="dark" style="width: 100%">
          <Submenu name="1">
            <template slot="title">
              <span> <b class="hidden-xs">Novel</b></span>
            </template>
            <MenuItem name="1-1">My Profile</MenuItem>
            <MenuItem name="1-2">My Balance</MenuItem>
            <MenuItem name="1-3">Account Setting</MenuItem>
            <MenuItem name="1-4">Logout</MenuItem>
          </Submenu>
            <Submenu name="2">
            <template slot="title">
              <span> <b class="hidden-xs">Education</b></span>
            </template>
            <MenuItem name="2-1">My Profile</MenuItem>
            <MenuItem name="2-2">My Balance</MenuItem>
            <MenuItem name="2-3">Account Setting</MenuItem>
            <MenuItem name="2-4">Logout</MenuItem>
          </Submenu>
          <Submenu name="3">
            <template slot="title">
              <span> <b class="hidden-xs">Sociaty</b></span>
            </template>
            <MenuItem name="3-1">My Profile</MenuItem>
            <MenuItem name="3-2">My Balance</MenuItem>
            <MenuItem name="3-3">Account Setting</MenuItem>
            <MenuItem name="3-4">Logout</MenuItem>
          </Submenu>
          <Submenu name="4">
            <template slot="title">
              <span> <b class="hidden-xs">Technology</b></span>
            </template>
            <MenuItem name="4-1">My Profile</MenuItem>
            <MenuItem name="4-2">My Balance</MenuItem>
            <MenuItem name="4-3">Account Setting</MenuItem>
            <MenuItem name="4-4">Logout</MenuItem>
          </Submenu>
          <Submenu name="5">
            <template slot="title">
              <span> <b class="hidden-xs">Children</b></span>
            </template>
            <MenuItem name="5-1">My Profile</MenuItem>
            <MenuItem name="5-2">My Balance</MenuItem>
            <MenuItem name="5-3">Account Setting</MenuItem>
            <MenuItem name="5-4">Logout</MenuItem>
          </Submenu>
          <Submenu name="6">
            <template slot="title">
              <span> <b class="hidden-xs">Daily Life</b></span>
            </template>
            <MenuItem name="6-1">My Profile</MenuItem>
            <MenuItem name="6-2">My Balance</MenuItem>
            <MenuItem name="6-3">Account Setting</MenuItem>
            <MenuItem name="6-4">Logout</MenuItem>
          </Submenu>
          <Submenu name="7">
            <template slot="title">
              <span> <b class="hidden-xs">Comic</b></span>
            </template>
            <MenuItem name="7-1">My Profile</MenuItem>
            <MenuItem name="7-2">My Balance</MenuItem>
            <MenuItem name="7-3">Account Setting</MenuItem>
            <MenuItem name="7-4">Logout</MenuItem>
          </Submenu>
    </Menu>
  </div>
</template>

<script>
  export default {
    name: "IndexNav",
  }
</script>

<style scoped>

</style>
