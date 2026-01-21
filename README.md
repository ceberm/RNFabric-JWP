
---

# Android New Architecture PoC: JW Player Integration

This repository is a **Proof of Concept (PoC)** demonstrating the successful integration of the **JW Player SDK** within the **Android New Architecture** environment.

The primary goal of this spike was to validate that the JW Player can operate seamlessly alongside Fabric components and modern UI frameworks without performance degradation or memory leaks.

## 🚀 Key Technologies

This project leverages the latest Android stack to ensure future-proofing and high performance:

* **Android New Architecture (Fabric):** Validating compatibility with the new C++ rendering engine.
* **Jetpack Compose & Material 3:** Modern, declarative UI implementation.
* **Android ViewModels:** Ensuring robust state management and lifecycle awareness.
* **Fragments:** Demonstrated interoperability between modern Compose views and traditional navigation patterns.

## 💡 Engineering Insights

While this PoC utilizes a "bleeding-edge" stack, it serves as a reference for architectural migration.

* **Modern vs. Legacy:** Although production environments often rely on older view-based approaches, this spike confirms that moving to the New Architecture mitigates potential dependency conflicts and improves memory management—areas that frequently become "troublesome" in legacy implementations.
* **Performance:** The integration demonstrates efficient bridge communication between the JW Player's underlying views and the Fabric renderer.

## 🛠️ Getting Started

1. Clone the repository.
2. Run `npm install`
3. Run`npx react-native run-android`.
4. Check the Result. Video should play when clicking the button.

---

## ⚠️ Known Limitations & Disclaimer

As this is a **Spike/Proof of Concept**, please keep the following in mind:

* **No Automated Testing:** This repository focuses on architectural feasibility and does not currently include Unit, Integration, or UI tests.
* **Feature Parity:** This project is a stripped-back implementation. It does **not** contain the full suite of features, business logic, or edge-case handling currently found in our production environment.
* **Stability:** While the New Architecture is functional here, this implementation has not been stress-tested for long-term production stability.

