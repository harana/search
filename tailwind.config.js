const defaultTheme = require('tailwindcss/defaultTheme')
const colors = require('tailwindcss/colors')

/** @type {import('tailwindcss').Config} */

export default {
    content: [
        "./src/css/*",
        "./src/css/*",
        "./src/fonts/*",
        "./src/html/*",
        "./src/main/*.{js,ts,jsx,tsx,scala}",
        "./target/*.{js,ts,jsx,tsx,scala,html}",
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

