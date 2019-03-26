<template>
  <div id="index" class="layout">
    <Layout>
      <Header>
        <common-nav :user="user" style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <IndexNav style="z-index:2;position: relative;margin-top: -4px;margin-bottom: 10px;"></IndexNav>
        <Carousel style="position: relative;"></Carousel>
        <recommendation></recommendation>
      </Content>

      <Footer>
        <my-footer></my-footer>
      </Footer>

    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import Carousel from "./common/Carousel";
  import IndexNav from "./common/IndexNav";
  import Recommendation from "./common/Recommendation";
  import MyFooter from "./common/MyFooter";

  export default {
    name: "Index",
    components: {MyFooter, Recommendation, IndexNav, Carousel, CommonNav},
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
