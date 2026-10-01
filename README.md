# AIPlaywright4x

Learning and deliverable repository for **AI / LLM fundamentals** and **AI-assisted QA & test engineering**.

Content is organised by chapter. Chapter 1 focuses on LLM basics and applies a strict, source-traceable documentation standard.

---

## Repository structure

```
AIPlaywright4x/
├── Chapter_01_LLM Basics/
│   ├── AI_Glossary_Keywords.md
│   ├── AI_Glossary_Infographic.png
│   ├── Open_vs_Closed_Source_Models_Guide.md
│   ├── Open_vs_Closed_Models_Infographic.png
│   ├── VWO_Test_Plan.md
│   ├── VWO_Test_Plan_Extracted_PRD.txt
│   ├── Anti-Hallucination_Rules.md
│   └── Product Requirements Document (PRD) VWO.com.pdf
└── image.png
```

---

## Chapter 1 — LLM Basics

| File | Description |
| --- | --- |
| `AI_Glossary_Keywords.md` | Beginner-friendly glossary of 30 AI/LLM keywords (token, RAG, embeddings, temperature, MCP, agents, evals, guardrails, etc.). Each term has a plain-language meaning, an everyday analogy, why it matters, and a cited source. |
| `AI_Glossary_Infographic.png` | One-page visual summary of the glossary: six colour-coded categories plus a production pipeline. |
| `Open_vs_Closed_Source_Models_Guide.md` | Research guide covering what *open source* vs *open weight* vs *closed source* models are, an inventory of available open-weight and closed models (2026), licensing, and a head-to-head comparison. |
| `Open_vs_Closed_Models_Infographic.png` | One-page visual summary of the open vs closed comparison. |
| `VWO_Test_Plan.md` | Test plan for the VWO (Visual Website Optimizer) platform at `https://app.vwo.com/`, derived from the PRD with full requirement traceability. |
| `VWO_Test_Plan_Extracted_PRD.txt` | Plain-text extraction of the PRD, used as the traceability source for the test plan. |
| `Anti-Hallucination_Rules.md` | Governing rules for AI-assisted documentation in this repo. |
| `Product Requirements Document (PRD) VWO.com.pdf` | Source PRD for VWO.com. |

---

## Conventions

Deliverables follow the `Anti-Hallucination_Rules.md`:

- **Verified Facts** — every assertion is traceable to a cited source.
- **Missing / Unknown Information** — gaps are declared ("Insufficient information to determine") rather than filled with assumptions.
- **Inferences** — anything inferred is explicitly labelled as low confidence.
- **Self-Validation** — each document ends with a self-check for accuracy and consistency.

---

## VWO Test Plan at a glance

- **Scope:** experimentation (A/B, Split URL, Multivariate), SmartStats, visual/code editors, heatmaps & session recordings, audience targeting, real-time reporting, personalization, integrations, collaboration.
- **Non-functional:** performance (≤ 2 s editing), security (2FA / RBAC / activity logs), scalability, data privacy (GDPR / CCPA), reliability (99.9% uptime SLA).
- **Coverage:** 25 test cases mapped to FR-1…FR-9, the non-functional requirements, and the two documented user flows.
