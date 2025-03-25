# Android CI/CD Process

This repository demonstrates an Android CI/CD process with a structured branching strategy and automated workflows. Below is an overview of the branch structure and the corresponding CI/CD actions triggered by different branches.

## Branching Strategy
- **feature/**: Used for developing new features. Each feature branch is created from `develop`. Pushes to this branch generate test APKs.
- **master**: Represents the production-ready code. Any changes merged into this branch trigger a production release.
- **develop**: The main integration branch for ongoing development. Merging into this branch triggers an internal test upload to the Google Play Store.
- **release/**: Used for preparing a new release. Merging into a `release/*` branch triggers a beta build.

### 1. Feature Branch (`feature/*`)
- Any push to a `feature/*` branch triggers:
  - Build process
  - Test APK generation as an artifact

### 2. Develop Branch (`develop`)
- Merging a feature branch into `develop` triggers:
  - Build process
  - Ui tests (with Maestro)
  - Uploads the build Github Action Artifacts

### 3. Release Branch (`release/*`)
- Creating or merging into a `release/*` branch triggers:
  - Build process
  - Ui tests (with Maestro)
  - Uploads the build Github Action Artifacts

### 4. Master Branch (`master`)
- Merging a release branch into `master` triggers:
  - Production release build
  - APK upload to Google Play Store (Internal app testing)

## Summary Table
| Branch        | Triggered Actions |
|--------------|-----------------|
| `feature/*`  | Build + Test APK Artifact |
| `develop`    | Internal Test Upload |
| `release/*`  | Beta Release Upload |
| `master`     | Production Release Upload |

