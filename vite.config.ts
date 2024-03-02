import { resolve } from 'path'
import { defineConfig } from 'vite'
import react from "@vitejs/plugin-react";
//import { sentryVitePlugin } from "@sentry/vite-plugin";

// @ts-ignore
export default defineConfig(async () => ({
  plugins: [
    react(),
    //sentryVitePlugin({
    //  org: "harana",
    //  project: "search",
    //  authToken: process.env.SENTRY_AUTH_TOKEN
    //})
  ],
  clearScreen: false,
  resolve: {
    alias: {
      '@assets': resolve(__dirname, 'src/assets'),
    },
  },
  server: {
    port: 1420,
    strictPort: true,
  },
  envPrefix: ['VITE_', 'TAURI_'],
  root: resolve(__dirname, 'target'),
  build: {
    target: ['es2021', 'chrome97', 'safari13'],
    minify: !process.env.TAURI_DEBUG && 'esbuild',
    sourcemap: true,
    rollupOptions: {
      input: {
        index: resolve(__dirname, 'target/index.html'),
        search: resolve(__dirname, 'target/index.html'),
        preview: resolve(__dirname, 'target/preview.html'),
      },
    },
  },
}));
