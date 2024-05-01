<template>
  <label class="form-label" id="child-id">
  {{ label }}
  </label>
  <input type="text" v-model="value" v-bind="$attrs">
</template>

<script>
import { computed } from 'vue'

  export default {
    props:['modelValue','label'],
    emits:['update:modelValue'],
    setup(props, {emit}){
      const value = computed({
        get(){
          return props.modelValue;
        },
        set(value){
          emit('update:modelValue',value);
        }
      })
      return {value};
    }
  }
</script>
