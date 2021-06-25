import Dynamic from './js/dynamic.js';

const app = Vue.createApp({});
app.component('dynamic', Dynamic);
app.mount('#dynamic');