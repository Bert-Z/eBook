<template>
  <div id="index" class="layout">
    <Layout>
      <Header :style="{width: '100%',background:'#fff',padding:'0'}">
        <common-nav style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <IndexNav style="z-index:2;position: relative;margin-top: -4px;margin-bottom: 10px;"></IndexNav>
        <Carousel style="position: relative;"></Carousel>
        <recommendation></recommendation>
      </Content>

      <Footer style="text-align: center" class="layout-footer-center">&copy; 2019 Posted by : Bert Zhang</Footer>

    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import Carousel from "./common/Carousel";
  import IndexNav from "./common/IndexNav";
  import Recommendation from "./common/Recommendation";

  export default {
    name: "Index",
    components: {Recommendation, IndexNav, Carousel, CommonNav}
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
