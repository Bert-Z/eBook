<template>
  <layout>
    <Header style="width: 100%;background: #fff;padding: 0">
      <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
    </Header>
    <Content>
      <edit-book-detail></edit-book-detail>
    </Content>
    <Footer>
      <my-footer></my-footer>
    </Footer>
  </layout>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import MyFooter from "./common/MyFooter";
  import EditBookDetail from "./admin/EditBookDetail";

  export default {
    name: "EditBook",
    components: {EditBookDetail, MyFooter, CommonNav},
    data: function () {
      return {
        user: true
      }
    }
  }
</script>

<style scoped>

</style>
