FROM node:alpine as build
RUN apk add nano
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# production environment
FROM nginx:stable-alpine
COPY --from=build /app/build /var/www/html
COPY --from=build /app/.nginx/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]