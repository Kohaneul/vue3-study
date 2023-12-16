<template>
	<h2>About View</h2>
	<p>{{ $route.path }}</p>
	<button class="btn btn-primary" @click="goAboutPage()">Home으로 이동</button>
</template>

<script setup>
import { useRouter } from 'vue-router';
const router = useRouter();
const goAboutPage = () => {
	router.push('/');
};
</script>

<style lang="scss" scoped></style>
