<template>
  <layout>
    <Header>
      <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
    </Header>
    <Content>
      <admin-index-show></admin-index-show>
    </Content>
    <Footer>
      <my-footer></my-footer>
    </Footer>
  </layout>
</template>

<script>
  import MyFooter from "./common/MyFooter";
  import CommonNav from "./common/CommonNav";
  import AdminIndexShow from "./admin/AdminIndexShow";

  export default {
    name: "Admin",
    components: {AdminIndexShow, CommonNav, MyFooter},
    data: () => {
      return {
        user: true
      }
    }
  }
</script>

<style scoped>

</style>
