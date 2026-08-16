# Distributed System Contracts

Versioned Kafka event payloads shared by `OrderingDistributedSystem` and `WarehouseDistributedSystem`.

## Compatibility Policy

1. Do not rename, remove, or change the type of a published field.
2. Additive fields must be optional or have a safe default.
3. Increase `eventVersion` only for an intentionally incompatible event change.
4. Publish a new Maven artifact version before a service consumes a changed contract.
5. Producers must not emit a new required field until every consumer supports it.

## Local Usage

Install the artifact before building either service:

```powershell
mvn clean install
```

The applications depend on `mk.ukim.finki.ds:distributed-system-contracts:1.0.0-SNAPSHOT`.
