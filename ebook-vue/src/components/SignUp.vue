<template>
  <div id="signup" class="layout">
    <Layout>
      <Header style="width: 100%;background: #fff;padding: 0">
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <SignUpTable></SignUpTable>
      </Content>
      <Footer>
        <my-footer></my-footer>
      </Footer>
    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import SignUpTable from "./common/SignUpTable";
  import MyFooter from "./common/MyFooter";

  export default {
    name: "SignUp",
    components: {MyFooter, SignUpTable, CommonNav},
    data: () => {
      return {
        user: false
      }
    }
  }
</script>

<style scoped>

</style>
