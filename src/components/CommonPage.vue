<template>
    <BasicGrid
              :title="titleRef"
              :pagingOptions="pagingOptionsRef"
              @button-clicked="buttonClicked">
    </BasicGrid>
</template>

<script lang ="ts">
import { ref } from 'vue';
import BasicGrid from './BasicGrid.vue';
  export default {
    components:{BasicGrid},
    setup(){
      const titleRef = ref('title');
      const pagingOptionsRef = [1,2,3,4];
      const buttonClicked= ()=>{
        console.log("hi");
      }
      return {titleRef,pagingOptionsRef,buttonClicked}
    }
  }
</script>

<style lang="scss" scoped>

</style>