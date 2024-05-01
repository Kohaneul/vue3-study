<template>
  <div class="card">
    <div v-if="$slots.header" class="card-header">
      <slot name="header" header-message="헤더메시지"></slot>
    </div>
    <div v-if="$slots.default" class="card-body">
      <slot :child-message="childMessage" hello-message="안녕하세요 !"></slot>
    </div>
    <div v-if="hasFooter" class="card-footer text-muted">
      <slot name="footer" footer-message="푸터 메시지"></slot>
    </div>

  </div>
</template>

<script>
import { ref,computed } from 'vue';

  export default {
    setup(props,{slots}){
    const childMessage=ref('자식 컴포넌트 메시지');
    const hasFooter = computed(()=>{
      !!slots.footer})
    return {childMessage};
    }
  }
</script>

<style lang="scss" scoped>

</style>