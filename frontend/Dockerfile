FROM node:lts-alpine AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:alpine
COPY --from=build /app/dist/bruna-webshop/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf