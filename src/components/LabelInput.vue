<template>
  <label class="form-label" id="child-id">
    {{ label }}
    <!-- :value="modelValue"
    @input="event=>$emit('update:modelValue')" -->
  </label>
  <input v-model="value" v-bind="$attrs" type="text" class="form-control">
</template>

<script>
import { computed } from 'vue';
  export default {
    props:['modelValue','label'],
    emits:['update:modelValue'],
    setup(props,{emit}){
      const value = computed({
        get(){
          return props.modelValue
        },
        set(value){
          emit('update:modelValue',value)
        }

      })
      return{value};
    },
  }
</script>

<style lang="scss" scoped>

</style>