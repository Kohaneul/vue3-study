import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import { createApp } from 'vue';
import App from './App.vue';
// import AppCard from '@/components/AppCard.vue';
import router from '@/router';
// createApp(App).use(router).mount('#app');
const app = createApp(App);
// app.component('AppCard',AppCard);
app.mount('#app');
import 'bootstrap/dist/js/bootstrap.js';
