<template>
  <div id="index" class="layout">
    <Layout>
      <Header style="width: 100%;background: #fff;padding: 0">
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <IndexNav style="z-index:2;position: relative;margin-top: -4px;margin-bottom: 10px;"></IndexNav>
        <book-list-detail></book-list-detail>
      </Content>

      <Footer>
        <my-footer></my-footer>
      </Footer>

    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import IndexNav from "./common/IndexNav";
  import BookListDetail from "./common/BookListTable";
  import MyFooter from "./common/MyFooter";

  export default {
    name: "BookList",
    components: {MyFooter, BookListDetail, IndexNav, CommonNav},
    data: () => {
      return {
        user: true
      }
    }
  }
</script>

<style scoped>
  .layout {
    border: 1px solid #d7dde4;
    /*background: #f5f7f9;*/
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
</style>
