<template>
  <main>
	<div class="container py-4">
		<div class="row g-3">
    <div class="col col-4">
			<AppCard></AppCard>
		</div>
		<div class="col col-4">
			<AppCard></AppCard>
		</div>   
		<div class="col col-4">
			<AppCard></AppCard>
		</div>
		<div class="col col-4">
			<AppCard></AppCard>
		</div>
		<div class="col col-4">
			<AppCard></AppCard>
		</div>
		<div class="col col-4">
			<AppCard></AppCard>
		</div>
  </div>
	</div>
</main>
</template>

<script>
console.log('AppCard')
import AppCard from '@/components/AppCard.vue';
  export default {
    components : {
			AppCard,
		}
  }
</script>

<style lang="scss" scoped>

</style>