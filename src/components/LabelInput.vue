<template>
  <div>
    <label>
      {{label}}
       <input v-model="value"
       type="text">
    </label>
  </div>
</template>

<script>
import {computed} from 'vue';
  export default {
    props:['modelValue','label'],
    emits:['update:modelValue'],
    setup(props,{emit}){
       const value = computed({
        get(){
          return props.modelValue;
        },
        set(value){
          emit('update:modelValue',value)
        },
       })
       return {value}
    }
  }
</script>

<style lang="scss" scoped>

</style>