<template>
  <div id="index" class="layout">
    <Layout>
      <Header :style="{width: '100%',background:'#fff',padding:'0'}">
        <common-nav style="z-index: 100;position:relative;"></common-nav>
      </Header>
      <Content>
        <IndexNav style="z-index:2;position: relative;margin-top: -4px;margin-bottom: 5px;"></IndexNav>
        <Carousel style="position: relative;"></Carousel>
      </Content>

      <Footer>

      </Footer>
    </Layout>
  </div>
</template>

<script>
  import CommonNav from "./common/CommonNav";
  import Carousel from "./common/Carousel";
  import IndexNav from "./common/IndexNav";

  export default {
    name: "Index",
    components: {IndexNav, Carousel, CommonNav}
  }
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    /*background: #f5f7f9;*/
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
</style>
