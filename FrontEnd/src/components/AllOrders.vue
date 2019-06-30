<template>
  <div id="allorders" class="layout">
    <Layout>
      <Header style="width: 100%;background: #fff;padding: 0">
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <AllOrderTable></AllOrderTable>
      </Content>

      <Footer>
        <MyFooter></MyFooter>
      </Footer>

    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import IndexNav from "./common/IndexNav";
  import MyFooter from "./common/MyFooter";
  import AllOrderTable from "./user/AllOrderTable";

  export default {
    name: "AllOrders",
    components: {AllOrderTable, MyFooter, IndexNav, CommonNav},
    data() {
      return {
        user: true,
      }
    }
  }
</script>

<style scoped>

</style>
