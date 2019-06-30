<template>
  <layout>
    <Header style="width: 100%;background: #fff;padding: 0">
      <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
    </Header>
    <Content>
      <SignInTable></SignInTable>
    </Content>
    <Footer>
      <my-footer></my-footer>
    </Footer>
  </layout>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import MyFooter from "./common/MyFooter";
  import SignInTable from "./common/SignInTable";

  export default {
    name: "SignIn",
    components: {SignInTable, MyFooter, CommonNav},
    data: () => {
      return {
        user: false
      }
    }
  }
</script>

<style scoped>

</style>
