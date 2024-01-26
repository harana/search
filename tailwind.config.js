const defaultTheme = require('tailwindcss/defaultTheme')
const colors = require('tailwindcss/colors')

/** @type {import('tailwindcss').Config} */

export default {
    content: [
        "./src/css/*",
        "./src/html/*",
        "./src/**/*.{js,ts,jsx,tsx,scala}",
        "./target/*",
    ],
    theme: {
        colors: {
            ...colors
        },
        extend: {
            fontFamily: {
                sans: ['Inter var', ...defaultTheme.fontFamily.sans],
            }
        },
    },
    plugins: [
        require('@tailwindcss/aspect-ratio'),
        require('@tailwindcss/forms'),
        require('@tailwindcss/typography')
    ],
}

