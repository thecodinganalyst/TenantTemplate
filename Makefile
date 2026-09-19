.PHONY: help db-up db-down backend frontend test
help:
	@echo "db-up db-down backend frontend test"
db-up:
	docker compose up -d postgres
db-down:
	docker compose down
backend:
	cd backend && mvn spring-boot:run
frontend:
	cd frontend && npm run dev
test:
	cd backend && mvn verify && cd ../frontend && npm ci && npm test -- --run
