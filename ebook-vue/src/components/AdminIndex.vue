<template>
  <Header>
    <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
  </Header>
  <Content>

  </Content>
  <Footer>
    <my-footer></my-footer>
  </Footer>
</template>

<script>
  import MyFooter from "./common/MyFooter";
  import CommonNav from "./common/CommonNav";

  export default {
    name: "AdminIndex",
    components: {CommonNav, MyFooter},
    data: () => {
      return {
        user: false
      }
    }
  }
</script>

<style scoped>

</style>
