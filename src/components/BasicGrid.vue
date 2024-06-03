<template>
  <div>{{ title }}</div>
  <select class="page-size">
        <option v-for="(opt, idx) in pagingOptions" :key="idx" :value="opt">
          {{ opt }}
        </option>
  </select>
  <button @click="$emit('buttonClicked')">Clicked</button>
</template>

<script>
import { computed,ref } from 'vue'
  export default {
    props:{
     pagingOptions:{
      type:Array
     }
    },
    setup(props, {emit}){
      const pagingOptions = computed (()=>{
        return props.pagingOptions;
      })
      const title = ref(props.title);
      return {pagingOptions,title}
      
    }
  }
</script>

<style lang="scss" scoped>

</style>